package com.devfabiosimones.gntech.repository;

import com.devfabiosimones.gntech.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoReposity extends JpaRepository<Endereco, Long> {
}
