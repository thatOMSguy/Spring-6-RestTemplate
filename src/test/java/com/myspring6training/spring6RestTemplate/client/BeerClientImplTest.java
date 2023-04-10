package com.myspring6training.spring6RestTemplate.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {


    @Autowired
    BeerClientImpl beerClient;

    @Test
    void listBeers() {

        beerClient.listBeers();
    }

}