package com.devfabiosimones.gntech.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ViaCEP", url = "https://viacep.com.br/ws/")
public interface ViaCepConfig {

}
