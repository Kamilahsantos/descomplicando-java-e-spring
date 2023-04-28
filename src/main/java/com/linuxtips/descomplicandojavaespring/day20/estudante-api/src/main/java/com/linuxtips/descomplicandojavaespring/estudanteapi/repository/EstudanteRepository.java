package com.linuxtips.descomplicandojavaespring.estudanteapi.repository;


import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {
}
