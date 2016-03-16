package com.qualiti.jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.qualiti.jhipster.domain.Endereco;
import com.qualiti.jhipster.service.EnderecoService;
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
 * REST controller for managing Endereco.
 */
@RestController
@RequestMapping("/api")
public class EnderecoResource {

    private final Logger log = LoggerFactory.getLogger(EnderecoResource.class);
        
    @Inject
    private EnderecoService enderecoService;
    
    /**
     * POST  /enderecos -> Create a new endereco.
     */
    @RequestMapping(value = "/enderecos",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) throws URISyntaxException {
        log.debug("REST request to save Endereco : {}", endereco);
        if (endereco.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("endereco", "idexists", "A new endereco cannot already have an ID")).body(null);
        }
        Endereco result = enderecoService.save(endereco);
        return ResponseEntity.created(new URI("/api/enderecos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("endereco", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /enderecos -> Updates an existing endereco.
     */
    @RequestMapping(value = "/enderecos",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco) throws URISyntaxException {
        log.debug("REST request to update Endereco : {}", endereco);
        if (endereco.getId() == null) {
            return createEndereco(endereco);
        }
        Endereco result = enderecoService.save(endereco);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("endereco", endereco.getId().toString()))
            .body(result);
    }

    /**
     * GET  /enderecos -> get all the enderecos.
     */
    @RequestMapping(value = "/enderecos",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<Endereco>> getAllEnderecos(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of Enderecos");
        Page<Endereco> page = enderecoService.findAll(pageable); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/enderecos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /enderecos/:id -> get the "id" endereco.
     */
    @RequestMapping(value = "/enderecos/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Endereco> getEndereco(@PathVariable Long id) {
        log.debug("REST request to get Endereco : {}", id);
        Endereco endereco = enderecoService.findOne(id);
        return Optional.ofNullable(endereco)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /enderecos/:id -> delete the "id" endereco.
     */
    @RequestMapping(value = "/enderecos/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        log.debug("REST request to delete Endereco : {}", id);
        enderecoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("endereco", id.toString())).build();
    }
}
