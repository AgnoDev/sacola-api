package me.dio.sacola.repository;

import me.dio.sacola.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // conectar com BD
public interface SacolaRepository extends JpaRepository<Sacola, Long> {

}
