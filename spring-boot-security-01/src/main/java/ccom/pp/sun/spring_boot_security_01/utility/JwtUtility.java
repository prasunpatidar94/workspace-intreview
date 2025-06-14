package ccom.pp.sun.spring_boot_security_01.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtility {
    private final static String SUPER_SECRET = "my-secret-key-my-secret-456-my-secret-123";
    private final static SecretKey secretKey = Keys.hmacShaKeyFor(SUPER_SECRET.getBytes());
    private final static Long EXP_TIME = 1000 * 60 * 60L;

    public static Claims extractedClaimFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean userDetailsValidation(String token, UserDetails userDetails, String userName) {
        return (
                userDetails.getUsername().equals(userName)
                        && isTokenExpired(token)
        );
    }

    private static boolean isTokenExpired(String token) {
        return extractedClaimFromToken(token).getExpiration().after(new Date());
    }

    public String creationAuthToken(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXP_TIME))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromRequestToken(String token) {
        return extractedClaimFromToken(token).getSubject();
    }
}
