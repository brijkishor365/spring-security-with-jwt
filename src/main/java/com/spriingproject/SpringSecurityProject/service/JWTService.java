package com.spriingproject.SpringSecurityProject.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Service class for handling JSON Web Token (JWT) operations.
 * This class provides functionality for generating, validating, and parsing JWTs
 * used for authentication and authorization in the application.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Service
public class JWTService {

    /** The secret key used for signing JWTs */
    private String secretKey = "";

    /**
     * Constructor that initializes the JWT service with a secure random key.
     * Generates a new HmacSHA256 secret key for JWT signing.
     *
     * @throws RuntimeException if the HmacSHA256 algorithm is not available
     */
    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generates a new JWT token for the specified username.
     * The token includes standard claims like subject, issued at, and expiration.
     *
     * @param username The username to include in the token
     * @return The generated JWT token string
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .and()
                .signWith(getKey())
                .compact();
    }

    /**
     * Retrieves the secret key used for JWT signing.
     * Decodes the base64 encoded secret key into a SecretKey object.
     *
     * @return The SecretKey object for JWT signing
     */
    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extracts the username from a JWT token.
     *
     * @param token The JWT token to extract the username from
     * @return The username stored in the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Generic method to extract a specific claim from a JWT token.
     *
     * @param <T> The type of the claim to extract
     * @param token The JWT token to extract the claim from
     * @param claimResolver Function to extract the specific claim
     * @return The extracted claim value
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    /**
     * Extracts all claims from a JWT token.
     *
     * @param token The JWT token to extract claims from
     * @return All claims stored in the token
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Validates a JWT token against user details.
     * Checks if the token's username matches the UserDetails and if the token is not expired.
     *
     * @param token The JWT token to validate
     * @param userDetails The UserDetails to validate against
     * @return true if the token is valid, false otherwise
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * Checks if a JWT token is expired.
     *
     * @param token The JWT token to check
     * @return true if the token is expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extracts the expiration date from a JWT token.
     *
     * @param token The JWT token to extract the expiration date from
     * @return The expiration date of the token
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
