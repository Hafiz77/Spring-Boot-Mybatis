package com;

import com.controller.CORSResponseFilter;
import com.controller.LoginController;
import com.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Hafiz on 11/8/2016.
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //register(TestController.class);
        register(CORSResponseFilter.class);
        register(UserController.class);
        register(LoginController.class);

    }

}
