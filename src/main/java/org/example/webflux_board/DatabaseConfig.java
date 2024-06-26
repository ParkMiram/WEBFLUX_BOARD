package org.example.webflux_board;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Profile("mysql")
@EnableR2dbcAuditing
@EnableR2dbcRepositories
@Configuration
public class DatabaseConfig {
}