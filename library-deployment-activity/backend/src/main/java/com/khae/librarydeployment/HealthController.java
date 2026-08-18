package com.khae.librarydeployment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/rest/health")
public class HealthController {
    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public Map<String, Object> health() {
        Integer databaseResult = jdbcTemplate.queryForObject("select 1", Integer.class);
        return Map.of(
                "status", "UP",
                "database", databaseResult != null && databaseResult == 1 ? "UP" : "DOWN",
                "timestamp", Instant.now().toString()
        );
    }
}
