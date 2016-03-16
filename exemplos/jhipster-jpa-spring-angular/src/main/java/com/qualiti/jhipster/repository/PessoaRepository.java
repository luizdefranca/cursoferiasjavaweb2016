package com.qualiti.jhipster.repository;

import com.qualiti.jhipster.domain.Pessoa;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Pessoa entity.
 */
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
