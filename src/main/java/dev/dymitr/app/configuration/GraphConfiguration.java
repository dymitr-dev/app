package dev.dymitr.app.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dymitr.app.model.Country;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Configuration
public class GraphConfiguration {
    @Bean
    public Graph graph() throws IOException {
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        File resource = new ClassPathResource("countries.json").getFile();
        String text = new String(Files.readAllBytes(resource.toPath()));
        List<Country> countries = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(text, new TypeReference<>() {});
        countries.forEach(country -> {
            graph.addVertex(country.getCca3());
            country.getBorders()
                    .forEach(border -> {
                        graph.addVertex(border);
                        graph.addEdge(country.getCca3(), border);
                    });
        });
        return graph;
    }
}
