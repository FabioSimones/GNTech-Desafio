package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Pedido;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.entity.dto.PedidoDTO;
import com.devfabiosimones.gntech.entity.dto.PedidoDTOResumido;
import com.devfabiosimones.gntech.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTOResumido dto) {
        Pedido pedido = pedidoService.criarPedido(dto.getNomeCliente(), dto.getCep(), dto.getItemIds());
        return ResponseEntity.status(HttpStatus.CREATED).body(new PedidoDTO(pedido));
    }

    @GetMapping("/{cep}")
    public ResponseEntity<List<Pedido>> buscarPorCep(@PathVariable String cep) {
        return ResponseEntity.ok(pedidoService.buscarPorCep(cep));
    }
}