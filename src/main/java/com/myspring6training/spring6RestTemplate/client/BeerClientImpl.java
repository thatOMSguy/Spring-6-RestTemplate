package com.myspring6training.spring6RestTemplate.client;

import com.myspring6training.spring6RestTemplate.model.BeerDTO;
import com.myspring6training.spring6RestTemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String BEER_V1_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers(String beerName) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(BEER_V1_PATH);

        if (beerName != null) {
            uriComponentsBuilder.queryParam("beerName", beerName);
        }

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<BeerDTOPageImpl> pageResp =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(),
                        BeerDTOPageImpl.class);

        /*ResponseEntity<Map> mapResp =
                restTemplate.getForEntity(BASE_URL + BEER_V1_PATH, Map.class);

        ResponseEntity<JsonNode> jsonResp =
                restTemplate.getForEntity(BASE_URL + BEER_V1_PATH, JsonNode.class);

        //System.out.println(stringResp.getBody());
        jsonResp.getBody().findPath("content")
                .elements().forEachRemaining(
                        jsonNode -> {
                            System.out.println(jsonNode.get("beerName").asText());
                        }
                );*/
        return pageResp.getBody();
    }
}
