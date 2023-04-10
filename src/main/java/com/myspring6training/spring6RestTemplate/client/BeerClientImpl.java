package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;


    @Override
    public Page<BeerDTO> listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> stringResp =
                restTemplate.getForEntity("http://localhost:8080/api/v1/beer", String.class);
        System.out.println(stringResp.getBody());
        return null;
    }
}
