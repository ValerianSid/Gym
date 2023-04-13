package by.valsid.gym.security;

import by.valsid.gym.config.ProjectConfiguration;
import by.valsid.gym.model.entity.GymUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class JwtUtil {

    ProjectConfiguration config;

    public String generateToken(final GymUser user) {
        final SecretKey key = getSecretKey();
        final Date expirationDate = Date.from(LocalDateTime.now()
                .plusHours(config.getSecurity().getTokenLifetimeHours())
                .atZone(ZoneId.systemDefault())
                .toInstant());
        return Jwts.builder()
                .setSubject("gym")
                .addClaims(Map.of("gymUser", user.getId().toString()))
                .setExpiration(expirationDate)
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public Claims validateAndGet(final String token) {
        final SecretKey key = getSecretKey();
        return Jwts.parserBuilder()
                .requireSubject("gym")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(config.getSecurity().getSecretKey().getBytes(StandardCharsets.UTF_8));
    }
}
