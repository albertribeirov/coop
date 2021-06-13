package br.com.cooperativa.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JSONMapper {

    private JSONMapper() {
        // Private constructor to prevent instance creation
    }

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
    public static final String ERRO_FORMATAR_JSON = "Erro ao converter objeto para JSON.";

    public static ObjectMapper getMapper() {
        objectMapper.setDateFormat(dateFormatter);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        return objectMapper;
    }
}
