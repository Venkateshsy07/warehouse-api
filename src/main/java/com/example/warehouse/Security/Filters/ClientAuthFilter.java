package com.example.warehouse.Security.Filters;

import com.example.warehouse.Security.AuthUtils;
import com.example.warehouse.entity.Client;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.exception.ClientNotfoundApiKeyException;
import com.example.warehouse.repository.ClientRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Component
@Slf4j
public class ClientAuthFilter extends OncePerRequestFilter {
    private static final String X_API_KEY = "X-Api-Key";
    private static final String X_CLIENT_SECRET = "X-Secret-Key";

    private final PasswordEncoder passwordEncoder;

    private final ClientRepository clientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("authenticating request for client...");
        String apikey = request.getHeader(X_API_KEY);
        String secretkey = request.getHeader(X_CLIENT_SECRET);

        log.info("validating client request; Found api-key= {}. secret-key= {}", isValid(apikey), isValid(secretkey));
        if (isValid(apikey) && isValid(secretkey)) {
            Client client = clientRepository.findByApiKey(apikey)
                    .orElseThrow(() -> {
                        log.info("Client not found by api-key: {}", apikey);
                        return new ClientNotfoundApiKeyException("Client Not Found");
                    });

            var doesMatch = passwordEncoder.matches(secretkey, client.getSecretKey());
            if (doesMatch && AuthUtils.getAuthentication().isEmpty()) {
                log.info("Client is authentic, updating security context.");
                var token = new UsernamePasswordAuthenticationToken(client.getOrganizationName(),
                        null, List.of(new SimpleGrantedAuthority(UserRole.CLIENT.name())));
                AuthUtils.setAuthentication(token);

                log.info("Client '{}' authenticated successfully", client.getOrganizationName());
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isValid(String value) {
        return value != null && !value.isBlank();
    }
}
