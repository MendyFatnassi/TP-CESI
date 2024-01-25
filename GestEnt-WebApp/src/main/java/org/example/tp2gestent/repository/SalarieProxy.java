package org.example.tp2gestent.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.CustomProperties;
import org.example.tp2gestent.model.Salarie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SalarieProxy {


    @Autowired
    private CustomProperties props;


    public Iterable<Salarie> getSalaries(){
        String baseApiUrl = props.getApiUrl();
        String getSalarieUrl = baseApiUrl + "/Salaries";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Salarie>> response = restTemplate.exchange(
                getSalarieUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Salarie>>() {}
        );

        log.debug("Get Salaries call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Salarie getSalarie(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getSalarieUrl = baseApiUrl + "/Salarie/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Salarie> response = restTemplate.exchange(
                getSalarieUrl,
                HttpMethod.GET,
                null,
                Salarie.class
        );

        log.debug("Get Salarie call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Salarie createSalarie(Salarie c) {
        String baseApiUrl = props.getApiUrl();
        String createSalarieUrl = baseApiUrl + "/Salarie";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Salarie> request = new HttpEntity<Salarie>(c);
        ResponseEntity<Salarie> response = restTemplate.exchange(
                createSalarieUrl,
                HttpMethod.POST,
                request,
                Salarie.class);

        log.debug("Create Salarie call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Salarie updateSalarie(Salarie c) {
        String baseApiUrl = props.getApiUrl();
        String updateSalarieUrl = baseApiUrl + "/achat/" + c.getSalarieId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Salarie> request = new HttpEntity<Salarie>(c);
        ResponseEntity<Salarie> response = restTemplate.exchange(
                updateSalarieUrl,
                HttpMethod.PUT,
                request,
                Salarie.class);

        log.debug("Update Salarie call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteSalarie(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteSalarieUrl = baseApiUrl + "/achat/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteSalarieUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Salarie call " + response.getStatusCode().toString());
    }
}

