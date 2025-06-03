package com.example.warehouse.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuthUtils {


    private AuthUtils() {
        //its utility class

    }
    public static Optional<Authentication> getAuthentication() {

        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
    }

    public static Optional<String> getCurrentUserName() {

         return getAuthentication().map(
                 auth-> auth.getName());


    }
}
