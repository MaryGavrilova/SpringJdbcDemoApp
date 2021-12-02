package ru.netology.springjdbcdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class ShopRepository {
    String getProductNameScript = read("getProductNameScript.sql");

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String getProductName(String name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        return namedParameterJdbcTemplate.queryForObject(getProductNameScript, namedParameters, String.class);
    }

    private String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
