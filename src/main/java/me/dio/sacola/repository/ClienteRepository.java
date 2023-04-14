package me.dio.sacola.repository;

import me.dio.sacola.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // conectar com BD
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
