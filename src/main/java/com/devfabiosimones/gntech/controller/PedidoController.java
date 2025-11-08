package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Pedido;
import com.devfabiosimones.gntech.entity.dto.ItemDTO;
import com.devfabiosimones.gntech.entity.dto.PedidoDTO;
import com.devfabiosimones.gntech.entity.dto.PedidoDTOResumido;
import com.devfabiosimones.gntech.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    @GetMapping("/{cep}")
    public ResponseEntity<List<PedidoDTO>> buscarPorCep(@PathVariable String cep) {
        List<PedidoDTO> dto = pedidoService.buscarPorCep(cep).stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}