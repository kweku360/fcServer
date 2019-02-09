package com.fantasycup;

import com.codahale.metrics.SharedMetricRegistries;
import com.fantasycup.bal.controllers.EventController;
import com.fantasycup.bal.controllers.GameController;
import com.fantasycup.bal.controllers.PlayerController;
import com.fantasycup.dao.Event.Event;
import com.fantasycup.dao.Event.EventDao;
import com.fantasycup.dao.Game.Game;
import com.fantasycup.dao.Game.GameDao;
import com.fantasycup.dao.Player.Player;
import com.fantasycup.dao.Player.PlayerDao;
import com.fantasycup.resources.EventResource;
import com.fantasycup.resources.GameResource;
import com.fantasycup.resources.PlayerResource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fantasycup.core.mapper.ValidationExceptionMapper;
import com.fantasycup.util.Constants;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class FantasyCupApplication extends Application<FantasyCupConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FantasyCupApplication().run(args);
    }

    private final HibernateBundle<FantasyCupConfiguration> hibernate = new HibernateBundle<FantasyCupConfiguration>(Game.class, Player.class, Event.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(FantasyCupConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "FantasyCup";
    }

    @Override
    public void initialize(final Bootstrap<FantasyCupConfiguration> bootstrap) {

       //Swagger Config
        bootstrap.addBundle(new SwaggerBundle<FantasyCupConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(FantasyCupConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
        //Migrations Configuration
        bootstrap.addBundle(new MigrationsBundle<FantasyCupConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(FantasyCupConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public String getMigrationsFileName() {
                return "migrations.xml";
            }
        });

        //Hibernate Configuration
        bootstrap.addBundle(hibernate);

    }

    @Override
    public void run(final FantasyCupConfiguration configuration,
                    final Environment environment) {

        // TODO: implement application
        //Daos
        GameDao gameDao = new GameDao(hibernate.getSessionFactory());
        PlayerDao playerDao = new PlayerDao(hibernate.getSessionFactory());
        EventDao eventDao = new EventDao(hibernate.getSessionFactory());

        //Controllers
        GameController gameController = new GameController(gameDao);
        PlayerController playerController = new PlayerController(playerDao);
        EventController eventController = new EventController(eventDao);

        //resources
        environment.jersey().register(new GameResource(gameController));
        environment.jersey().register(new PlayerResource(playerController));
        environment.jersey().register(new EventResource(eventController));
        // END APPLICATION IMPLEMENTATION

        //Config options

        SharedMetricRegistries.add(Constants.METRICS_NAME, environment.metrics());
        environment.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        environment.getObjectMapper().setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        environment.getObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //Exception Mappers
        environment.jersey().register(new ValidationExceptionMapper());
        //Http Headers
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter("allowedOrigins", "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,X-Signal-Agent");
        filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter("preflightMaxAge", "5184000");
        filter.setInitParameter("allowCredentials", "true");

    }

}
