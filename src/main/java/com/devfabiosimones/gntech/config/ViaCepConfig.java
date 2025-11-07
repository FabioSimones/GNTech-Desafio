package com.devfabiosimones.gntech.config;

import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepConfig {

    @GetMapping("/{cep}/json/")
    EnderecoDTO consultarCep(@PathVariable("cep") String cep);
}
