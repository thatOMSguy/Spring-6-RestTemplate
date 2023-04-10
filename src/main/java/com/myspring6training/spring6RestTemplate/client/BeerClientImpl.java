package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String BASE_URL = "http://localhost:8080";
    private static final String BEER_V1_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> stringResp =
                restTemplate.getForEntity(BASE_URL + BEER_V1_PATH, String.class);

        ResponseEntity<Map> mapResp =
                restTemplate.getForEntity(BASE_URL + BEER_V1_PATH, Map.class);

        //System.out.println(stringResp.getBody());
        System.out.println(mapResp.getBody().toString());
        return null;
    }
}
