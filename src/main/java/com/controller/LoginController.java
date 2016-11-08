package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;

/**
 * Created by Hafiz on 11/8/2016.
 */
@Controller
@Path("/login")
public class LoginController {
    static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Autowired
    private UserMapper userMapper;

    @POST
    @Produces("application/json")
    public Response login(@HeaderParam("email") String email, @HeaderParam("password") String password) {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();

        try {
            User user = userMapper.login(email,password);

            if (user == null) {
                response.put("msg", "Invalid User");
            } else {
                response.put("msg", "Login Success");
                response.put("user", user);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {
            response.put("user", "Not Found");
            return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }
    }

}
