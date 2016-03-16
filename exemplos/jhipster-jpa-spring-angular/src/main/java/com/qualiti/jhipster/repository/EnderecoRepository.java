package com.qualiti.jhipster.repository;

import com.qualiti.jhipster.domain.Endereco;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Endereco entity.
 */
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

}
