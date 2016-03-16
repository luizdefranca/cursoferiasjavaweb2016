package com.qualiti.jhipster.service;

import com.qualiti.jhipster.domain.Pessoa;
import com.qualiti.jhipster.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Pessoa.
 */
@Service
@Transactional
public class PessoaService {

    private final Logger log = LoggerFactory.getLogger(PessoaService.class);
    
    @Inject
    private PessoaRepository pessoaRepository;
    
    /**
     * Save a pessoa.
     * @return the persisted entity
     */
    public Pessoa save(Pessoa pessoa) {
        log.debug("Request to save Pessoa : {}", pessoa);
        Pessoa result = pessoaRepository.save(pessoa);
        return result;
    }

    /**
     *  get all the pessoas.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Pessoa> findAll(Pageable pageable) {
        log.debug("Request to get all Pessoas");
        Page<Pessoa> result = pessoaRepository.findAll(pageable); 
        return result;
    }

    /**
     *  get one pessoa by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Pessoa findOne(Long id) {
        log.debug("Request to get Pessoa : {}", id);
        Pessoa pessoa = pessoaRepository.findOne(id);
        return pessoa;
    }

    /**
     *  delete the  pessoa by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pessoa : {}", id);
        pessoaRepository.delete(id);
    }
}
