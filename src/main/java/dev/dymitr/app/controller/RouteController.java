package dev.dymitr.app.controller;

import dev.dymitr.app.model.Route;
import dev.dymitr.app.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/routing/{origin}/{destination}")
    public Route getRoute(@PathVariable String origin, @PathVariable String destination) {
        return routeService.getRoute(origin, destination);
    }
}
