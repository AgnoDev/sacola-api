package me.dio.sacola.service.implement;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.resourceController.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplementsSacolaService implements SacolaService {
    private final SacolaRepository sacolaRepository;

    @Override
    public Item incluirItem(ItemDto itemDto) {
        return null;
    }

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow( // tratamento de Exception
                ()-> {throw new RuntimeException("Essa sacola não existe!");}
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int formaPagto) {
        return null;
    }
}
