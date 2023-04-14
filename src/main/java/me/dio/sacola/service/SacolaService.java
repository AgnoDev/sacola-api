package me.dio.sacola.service;

import me.dio.sacola.resourceController.dto.ItemDto;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import org.springframework.stereotype.Service;

public interface SacolaService {

    Item incluirItem(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagto);


}
