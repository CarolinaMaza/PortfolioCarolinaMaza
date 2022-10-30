package com.portfolio.CMaza.Repository;

import com.portfolio.CMaza.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {

    public Optional<Experiencia> findByEmpresaEx(String empresaEx);

    public boolean existsByEmpresaEx(String empresaEx);
}
