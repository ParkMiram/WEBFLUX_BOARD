package org.example.webflux_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "org.example.webflux_board.repository")
@EntityScan(basePackages = "org.example.webflux_board.model")
public class WebfluxBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxBoardApplication.class, args);
    }

}
