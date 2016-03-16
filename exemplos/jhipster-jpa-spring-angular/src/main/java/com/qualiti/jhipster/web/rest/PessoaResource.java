package com.qualiti.jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.qualiti.jhipster.domain.Pessoa;
import com.qualiti.jhipster.service.PessoaService;
import com.qualiti.jhipster.web.rest.util.HeaderUtil;
import com.qualiti.jhipster.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Pessoa.
 */
@RestController
@RequestMapping("/api")
public class PessoaResource {

    private final Logger log = LoggerFactory.getLogger(PessoaResource.class);
        
    @Inject
    private PessoaService pessoaService;
    
    /**
     * POST  /pessoas -> Create a new pessoa.
     */
    @RequestMapping(value = "/pessoas",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) throws URISyntaxException {
        log.debug("REST request to save Pessoa : {}", pessoa);
        if (pessoa.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("pessoa", "idexists", "A new pessoa cannot already have an ID")).body(null);
        }
        Pessoa result = pessoaService.save(pessoa);
        return ResponseEntity.created(new URI("/api/pessoas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("pessoa", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pessoas -> Updates an existing pessoa.
     */
    @RequestMapping(value = "/pessoas",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) throws URISyntaxException {
        log.debug("REST request to update Pessoa : {}", pessoa);
        if (pessoa.getId() == null) {
            return createPessoa(pessoa);
        }
        Pessoa result = pessoaService.save(pessoa);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("pessoa", pessoa.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pessoas -> get all the pessoas.
     */
    @RequestMapping(value = "/pessoas",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<Pessoa>> getAllPessoas(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Pessoas");
        Page<Pessoa> page = pessoaService.findAll(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pessoas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /pessoas/:id -> get the "id" pessoa.
     */
    @RequestMapping(value = "/pessoas/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Pessoa> getPessoa(@PathVariable Long id) {
        log.debug("REST request to get Pessoa : {}", id);
        Pessoa pessoa = pessoaService.findOne(id);
        return Optional.ofNullable(pessoa)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /pessoas/:id -> delete the "id" pessoa.
     */
    @RequestMapping(value = "/pessoas/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        log.debug("REST request to delete Pessoa : {}", id);
        pessoaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("pessoa", id.toString())).build();
    }
}
