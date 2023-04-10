package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

public interface BeerClient {


    Page<BeerDTO> listBeers();
}
