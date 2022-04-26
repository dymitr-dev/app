package dev.dymitr.app.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Route {
    private List<String> route;
}
