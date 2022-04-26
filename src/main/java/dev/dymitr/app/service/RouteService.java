package dev.dymitr.app.service;

import dev.dymitr.app.model.Route;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private Graph graph;

    public Route getRoute(String origin, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(origin, destination).getVertexList();
        return Route.builder().route(shortestPath).build();
    }
}
