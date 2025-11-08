package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.entity.dto.ItemDTO;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import com.devfabiosimones.gntech.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
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
        List<EnderecoDTO> dto = enderecoService.listarEnderecos().stream()
                .map(EnderecoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}