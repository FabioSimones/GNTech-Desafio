package com.devfabiosimones.gntech.repository;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoReposity extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByCep(String cep);
}
