package com.devfabiosimones.gntech.controller;

import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.dto.ItemDTO;
import com.devfabiosimones.gntech.repository.ItemRepository;
import com.devfabiosimones.gntech.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Item> criarItem(@Valid @RequestBody ItemDTO dto) {
        Item item = itemService.criarItem(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();

        return ResponseEntity.created(uri).body(item);
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarItens() {
        List<ItemDTO> itens = itemService.listarItens().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(itens);
    }
}
