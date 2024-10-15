package com.bankaya.pokemon.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class InfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public void insertDataInfo(String ip, String method, int time, String pokemonName, String response) {
        jdbcTemplate.update("INSERT INTO BNKY.POKE01_RQST (TX_IP, TX_METHOD, NU_TIME_REQUEST, TX_REQUEST, TX_RESPONSE) "
                + "VALUES (?, ?, ?, ?, ?)", ip, method, time, pokemonName, response);
    }
}
