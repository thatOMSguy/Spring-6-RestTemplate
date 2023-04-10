package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import com.myspring6training.spring6RestTemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {


    @Autowired
    BeerClientImpl beerClient;


    @Test
    void testDeleteBeer() {
        BeerDTO newBeer = BeerDTO.builder()
                .price(new BigDecimal("10.89"))
                .beerName("KF Smooth")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("85668097689548").build();

        BeerDTO savedBeer = beerClient.createNewBeer(newBeer);

        beerClient.deleteBeer(savedBeer.getId());

        assertThrows(HttpClientErrorException.class, () -> {
            beerClient.getBeerById(savedBeer.getId());
        });


    }

    @Test
    void testUpdateBeer() {
        BeerDTO newBeer = BeerDTO.builder()
                .price(new BigDecimal("10.89"))
                .beerName("KF Ultra")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("85669789548").build();

        BeerDTO savedBeer = beerClient.createNewBeer(newBeer);

        final String newName = "KD Ultra 23";
        savedBeer.setBeerName(newName);
        BeerDTO updatedBeer = beerClient.updateBeer(savedBeer);

        assertEquals(newName, updatedBeer.getBeerName());
    }


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