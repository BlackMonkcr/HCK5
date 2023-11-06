package com.example.backend_.repositories;
import com.example.backend_.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}