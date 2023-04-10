package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import com.myspring6training.spring6RestTemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientImplTest {


    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testCreateBeer() {
        BeerDTO newBeer = BeerDTO.builder()
                .price(new BigDecimal("10.89"))
                .beerName("KF Ultra")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("85669789548").build();

        BeerDTO savedBeer = beerClient.createNewBeer(newBeer);

        assertNotNull(savedBeer);
    }

    @Test
    void getBeerById() {
        Page<BeerDTO> beerDTOS = beerClient.listBeers();
        BeerDTO dto = beerDTOS.getContent().get(0);

        BeerDTO beerById = beerClient.getBeerById(dto.getId());

        assertNotNull(beerById);
    }

    @Test
    void listBeersNoBeerName() {

        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", null, null, null, null);
    }


}