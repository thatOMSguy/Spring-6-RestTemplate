package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import com.myspring6training.spring6RestTemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {


    Page<BeerDTO> listBeers();

    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                            Integer pageSize);
}
