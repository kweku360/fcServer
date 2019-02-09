package com.fantasycup;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class FantasyCupConfiguration extends Configuration {
//    @NotNull
//    @Valid
//    @JsonProperty
//    private RedisConfiguration cache;

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty
    private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return httpClient;
    }
//
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
