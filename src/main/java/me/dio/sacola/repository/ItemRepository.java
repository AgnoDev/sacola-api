package me.dio.sacola.repository;

import me.dio.sacola.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // conectar com BD
public interface ItemRepository extends JpaRepository<Item, Long> {

}
