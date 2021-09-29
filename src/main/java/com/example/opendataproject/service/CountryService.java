package com.example.opendataproject.service;

import com.example.opendataproject.domain.Record;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
public class CountryService {

    private String date = "2021-09-24";
    private final String JSON_URL = "https://data.gov.lv/dati/lv/api/3/action/datastore_search?q="+date+"&resource_id=8ea0ee31-1bea-4336-bbe4-2e66ccdadd1b";
    String jsonString = "";
    RestTemplate restTemplate = new RestTemplate();

    public CountryService() {
    }

    public ArrayList<String> getCountries() throws JsonProcessingException {
        List<Record> records = getRecords();
        ArrayList<String> countries = new ArrayList<>();
        for(Record record:records){
            countries.add(record.getValsts());
        }
        return countries;
    }

    public List<Record> getRecords() throws JsonProcessingException {
        if(LocalDate.now().equals(LocalDate.parse(date).plusDays(7))){
            date = LocalDate.now().toString();
        }
        jsonString = restTemplate.getForObject(JSON_URL, String.class);
        JSONObject jo = new JSONObject(jsonString);
        JSONArray ja = jo.getJSONObject("result").getJSONArray("records");

        final ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(ja.toString(), new TypeReference<List<Record>>() {});
    }
}
