package br.com.smartcarweb.api.apoio.jwt.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 */
@Provider
@JWTToken
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenFilter implements ContainerRequestFilter {

    // ======================================
    // =          Injection Points          =
    // ======================================

    // ======================================
    // =          Business methods          =
    // ======================================
	
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        System.out.println("#### authorizationHeader : " + authorizationHeader);
        System.out.println(requestContext.getUriInfo().getAbsolutePath());
        System.out.println(requestContext.getUriInfo().getBaseUri());
        System.out.println(requestContext.getUriInfo().getPath());
        System.out.println(requestContext.getUriInfo().getRequestUri());
        
        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
        	System.out.println("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
//        this.token = token;
        try {
//            JWTUtil.decode(token);
//
//    		String user =  JWTUtil.getUser(this.token);
            
            
        } catch (Exception e) {
        	String message = "\"" + e.getMessage() + "\"";
        	System.out.println("#### invalid token : " + token);
        	requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(message)
                    .type(MediaType.APPLICATION_JSON).build());        	
        }
    }
}