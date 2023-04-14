package me.dio.sacola.resourceController;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.resourceController.dto.ItemDto;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood/sacola")
@RequiredArgsConstructor // cria construtor da classe SacolaService
public class SacolaResource {
    private final SacolaService sacolaService; // injeção de dependencia

    @PostMapping() // para persistir informações no BD
    public Item incluirItem(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirItem(itemDto);
    }

    @GetMapping("/{id}") // para buscar no BD
    public Sacola verSacola(@PathVariable("id") Long id) {
        return sacolaService.verSacola(id);
    }

    @PatchMapping("(fechar/{idSacola}")// para alterações parciais no BD
    public Sacola fecharSacola(@PathVariable("idSacola") Long idSacola,
                               @RequestParam("formaPagto") int formaPagto) {
        return sacolaService.fecharSacola(idSacola, formaPagto);
    }
}
