package com.devfabiosimones.gntech.repository;

import com.devfabiosimones.gntech.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByEnderecoCep(String cepNormalizado);
}
