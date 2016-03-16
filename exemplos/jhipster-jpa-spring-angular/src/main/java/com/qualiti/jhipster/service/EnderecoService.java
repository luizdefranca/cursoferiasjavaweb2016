package com.qualiti.jhipster.service;

import com.qualiti.jhipster.domain.Endereco;
import com.qualiti.jhipster.repository.EnderecoRepository;
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
 * Service Implementation for managing Endereco.
 */
@Service
@Transactional
public class EnderecoService {

    private final Logger log = LoggerFactory.getLogger(EnderecoService.class);
    
    @Inject
    private EnderecoRepository enderecoRepository;
    
    /**
     * Save a endereco.
     * @return the persisted entity
     */
    public Endereco save(Endereco endereco) {
        log.debug("Request to save Endereco : {}", endereco);
        Endereco result = enderecoRepository.save(endereco);
        return result;
    }

    /**
     *  get all the enderecos.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Endereco> findAll(Pageable pageable) {
        log.debug("Request to get all Enderecos");
        Page<Endereco> result = enderecoRepository.findAll(pageable); 
        return result;
    }

    /**
     *  get one endereco by id.
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Endereco findOne(Long id) {
        log.debug("Request to get Endereco : {}", id);
        Endereco endereco = enderecoRepository.findOne(id);
        return endereco;
    }

    /**
     *  delete the  endereco by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Endereco : {}", id);
        enderecoRepository.delete(id);
    }
}
