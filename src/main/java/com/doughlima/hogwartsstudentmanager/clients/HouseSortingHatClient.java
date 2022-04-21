package com.doughlima.hogwartsstudentmanager.clients;

import com.doughlima.hogwartsstudentmanager.dto.SortingHatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class HouseSortingHatClient {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    private final String SORTING_HAT_API = "https://api-harrypotter.herokuapp.com/sortinghat";

    public SortingHatResponse execute() {

        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<SortingHatResponse> exchange = restTemplate.exchange(
                    SORTING_HAT_API,
                    HttpMethod.GET,
                    entity,
                    SortingHatResponse.class
            );
            if(exchange.getStatusCode().isError()) throw new RestClientException(exchange.getStatusCode().toString());
            return exchange.getBody();

    }

}
