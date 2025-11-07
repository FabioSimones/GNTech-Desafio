package com.devfabiosimones.gntech.repository;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.projections.EnderecoDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoReposity extends JpaRepository<Endereco, Long> {

    @Query(nativeQuery = true, value = """
				SELECT tb_endereco.cep AS cep
                FROM tb_endereco
				WHERE tb_endereco.cep = :cep
			""")
    List<EnderecoDetailsProjection> buscaCepNoBanco(String cep);

    Optional<Endereco> findByCep(String cep);
}
