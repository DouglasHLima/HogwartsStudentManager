package com.doughlima.hogwartsstudentmanager.clients;

import com.doughlima.hogwartsstudentmanager.dto.HouseInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HouseInfoClient {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;


    private final String HOUSE_INFO_API = "https://api-harrypotter.herokuapp.com/house/";

    public HouseInfoResponse execute(UUID houseID) {
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<HouseInfoResponse> exchange = restTemplate.exchange(
                HOUSE_INFO_API + houseID,
                HttpMethod.GET,
                entity,
                HouseInfoResponse.class
        );
        if (exchange.getStatusCode().isError()) throw new RestClientException(exchange.getStatusCode().toString());
        return exchange.getBody();
    }

}
