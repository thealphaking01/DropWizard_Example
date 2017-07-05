package anon;

import anon.rest.services.ServiceRESTController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javafx.stage.Stage;

//import javax.ws.rs;
//import javax.security.auth.login.Configuration;
import io.dropwizard.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by abdur.rahman on 31/05/17.
 */
public class App extends Application<Configuration>{

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources");
        environment.jersey().register(new ServiceRESTController(environment.getValidator()));


//
//        //Setup Basic Security
//        e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
//                .setAuthenticator(new AppAuthenticator())
//                .setAuthorizer(new AppAuthorizer())
//                .setRealm("App Security")
//                .buildAuthFilter()));
//        e.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
//        e.jersey().register(RolesAllowedDynamicFeature.class);
    }


    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
