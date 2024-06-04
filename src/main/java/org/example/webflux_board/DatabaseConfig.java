package org.example.webflux_board;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

//@Configuration
//@EnableR2dbcAuditing
public class DatabaseConfig {
//        extends AbstractR2dbcConfiguration {
//    @Override
    public ConnectionFactory connectionFactory() {
//        return ConnectionFactories.get(
//            ConnectionFactoryOptions.builder()
//                .option(ConnectionFactoryOptions.DRIVER, "oracle")
//                .option(ConnectionFactoryOptions.HOST, "localhost")
//                .option(ConnectionFactoryOptions.PORT, 1521)
//                .option(ConnectionFactoryOptions.DATABASE, "boards")
//                .option(ConnectionFactoryOptions.USER, "system")
//                .option(ConnectionFactoryOptions.PASSWORD, "oracle")
//                .build()
//        );
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER, "mysql")
                        .option(ConnectionFactoryOptions.HOST, "localhost")
                        .option(ConnectionFactoryOptions.PORT, 3306)
                        .option(ConnectionFactoryOptions.DATABASE, "webflux")
                        .option(ConnectionFactoryOptions.USER, "root")
                        .option(ConnectionFactoryOptions.PASSWORD, "1234")
                        .build()
        );
    }
}
