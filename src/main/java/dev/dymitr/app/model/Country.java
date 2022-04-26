package dev.dymitr.app.model;

import lombok.Data;

import java.util.List;

@Data
public class Country {
    private String cca3;
    private List<String> borders;
}
