package me.dio.sacola.service.implement;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.enumeration.FormaPagto;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Restaurante;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.repository.ItemRepository;
import me.dio.sacola.repository.ProdutoRepository;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.resourceController.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplementsSacolaService implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;

    @Override
    public Item incluirItem(ItemDto itemDto) { // item passado pelo cliente/front em JSon
        Sacola sacola = verSacola(itemDto.getIdSacola()); // pega o itemDto e coloca na sacola

        if (sacola.getFechada()) { // testa se a sacola está fechada
            throw new RuntimeException("Esta sacola esta fechada"); // tratamento de exceção
        }
        Item criaItem = Item.builder()
                .quantidade(itemDto.getQuantidade())
                .sacola(sacola)
                .produto(produtoRepository.findById(itemDto.getIdProduto()).orElseThrow(
                        () -> {
                            throw new RuntimeException("Esse produto não existe!");
                        }
                ))
                .build();
        List<Item> itensDaSacola = sacola.getItens();
        if (itensDaSacola.isEmpty()) {
            itensDaSacola.add(criaItem);
        } else {
            Restaurante restauranteDaSacola = itensDaSacola.get(0).getProduto().getRestaurante();
            Restaurante restauranteDoItem = criaItem.getProduto().getRestaurante();
            if (restauranteDaSacola.equals(restauranteDoItem)) {
                itensDaSacola.add(criaItem);
            } else {
                throw new RuntimeException
                        ("Não é possível adicionar itens de restaurantes diferentes numa mesma sacola." +
                                "Favor abrir nova sacola.");
            }
        }
        sacolaRepository.save(sacola);
        return itemRepository.save(criaItem);
    }

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow( // tratamento de Exception
                () -> {
                    throw new RuntimeException("Essa sacola não existe!");
                });
    }

    @Override
    public Sacola fecharSacola(Long id, int nFormaPagto) {
        Sacola sacola = verSacola(id);
        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }
        FormaPagto formaPagto =
                nFormaPagto == 0 ? FormaPagto.DINHEIRO : FormaPagto.MAQUINETA;
        sacola.setFormaPagto(formaPagto);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);
    }
}
