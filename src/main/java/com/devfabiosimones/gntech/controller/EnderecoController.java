package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import com.devfabiosimones.gntech.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoReposity enderecoRepository;
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoReposity enderecoRepository, EnderecoService enderecoService) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoService = enderecoService;
    }

    @Transactional
    @PostMapping("/{cep}")
    public ResponseEntity<Endereco> salvarEndereco(@PathVariable String cep) {
        Endereco endereco = enderecoService.buscarESalvarEndereco(cep);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}")
                .buildAndExpand(endereco.getCep()).toUri();

        return ResponseEntity.created(uri).body(endereco);
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
        List<EnderecoDTO> dtos = enderecoRepository.findAll().stream()
                .map(e -> new EnderecoDTO(
                        e.getCep(), e.getLogradouro(), e.getBairro(),
                        e.getLocalidade(), e.getUf(), e.getDdd(), e.getPedidos()))
                .toList();

        return ResponseEntity.ok(dtos);
    }


}