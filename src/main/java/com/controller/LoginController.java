package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.text.DateFormat;

import java.util.LinkedHashMap;


/**
 * Created by Hafiz on 11/8/2016.
 */
@Controller
@Path("/")
public class LoginController {
    static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpSession httpSession;

    @POST
    @Produces("application/json")
    @Path("/login")
    public Response login(User requestUser, @Context HttpServletRequest request) {
        LinkedHashMap<String, Object> loginResponse = new LinkedHashMap<String, Object>();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

        try {
            User user = userMapper.login(requestUser.getEmail(), requestUser.getPassword());

            if (user == null) {
                loginResponse.put("msg", "Invalid User");
            } else {
                httpSession = request.getSession();
                httpSession.setAttribute("user", user);
                httpSession.setMaxInactiveInterval(2 * 15);

                loginResponse.put("msg", "Login Success");
                loginResponse.put("sessionCreate", formatter.format(httpSession.getCreationTime()));
                loginResponse.put("lastAccess", formatter.format(httpSession.getLastAccessedTime()));
                loginResponse.put("InactiveTimeOut", httpSession.getMaxInactiveInterval());
                loginResponse.put("loggedInUser", httpSession.getAttribute("user"));

            }
            return Response.status(Response.Status.OK).entity(loginResponse).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
        } catch (Exception ex) {
            loginResponse.put("user", "Not Found");
            return Response.status(Response.Status.BAD_REQUEST).entity(loginResponse).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        LinkedHashMap<String, Object> loginResponse = new LinkedHashMap<String, Object>();
        try {
            httpSession = request.getSession();
            httpSession.invalidate();
            loginResponse.put("msg", "Logout Success");
            return Response.status(Response.Status.OK).entity(loginResponse).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
        } catch (Exception ex) {
            loginResponse.put("user", "Not Found");
            return Response.status(Response.Status.BAD_REQUEST).entity(loginResponse).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
        }
    }

}
