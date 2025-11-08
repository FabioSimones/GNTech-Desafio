package com.devfabiosimones.gntech.service;

import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.dto.ItemDTO;
import com.devfabiosimones.gntech.repository.ItemRepository;
import com.devfabiosimones.gntech.service.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item criarItem(ItemDTO dto) {
        verificaCampoItens(dto);
        Item item = new Item();
        item.setNomeProduto(dto.getNomeProduto());
        item.setQuantidade(dto.getQuantidade());
        item.setPrecoUnitario(dto.getPrecoUnitario());
        return itemRepository.save(item);

    }

    private void verificaCampoItens(ItemDTO dto) {
        if (dto.getNomeProduto() == null || dto.getNomeProduto().trim().isEmpty()) {
            throw new BadRequestException("O campo 'nomeProduto' é obrigatório e não pode estar vazio.");
        }
        if (dto.getQuantidade() == null || dto.getQuantidade() < 1) {
            throw new BadRequestException("O campo 'quantidade' é obrigatório e deve ser maior que zero.");
        }
        if (dto.getPrecoUnitario() == null || dto.getPrecoUnitario().compareTo(new java.math.BigDecimal("0.01")) < 0) {
            throw new BadRequestException("O campo 'precoUnitario' é obrigatório e deve ser maior que zero.");
        }
    }

    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

}
