package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.Pedido;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import com.devfabiosimones.gntech.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> consultarEndereco(@PathVariable String cep) {
        Endereco endereco = enderecoService.buscarOuSalvarEndereco(cep);
        return ResponseEntity.ok(endereco);
    }

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