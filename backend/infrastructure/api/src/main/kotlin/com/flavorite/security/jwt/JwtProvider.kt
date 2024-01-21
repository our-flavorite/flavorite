package com.flavorite.security.jwt

import com.flavorite.security.model.JsonWebToken
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*


@Component
class JwtProvider(
    @Value("\${jwt.secret}")
    private val secretKey: String
) {
    private val key: Key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))

    fun issue(authentication: Authentication): JsonWebToken {
        val authorities: String = authentication.authorities
            .map { it.authority }
            .joinToString { "," }

        val accessToken = Jwts.builder()
            .setSubject(authentication.name)
            .claim("role", authorities)
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 30))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()

        val refreshToken = Jwts.builder()
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 36))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()

        return JsonWebToken(accessToken, refreshToken)
    }

    fun extractAuthentication(accessToken: String): Authentication {
        //토큰 복호화
        val claims: Claims = parseClaims(accessToken)

        val authority = claims["role"] ?: throw RuntimeException("권한 정보가 없는 토큰입니다.")

        val authorities = authority.toString()
            .split(",")
            .map { SimpleGrantedAuthority(it) }

        val userDetails: UserDetails = User(claims.subject, "", authorities)

        return UsernamePasswordAuthenticationToken(userDetails, "", authorities)
    }

    private fun parseClaims(accessToken: String): Claims {
        return try {
            Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .body
        } catch (e: ExpiredJwtException) {
            e.claims
        }
    }

    fun validate(token: String) {
        try {
            Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
        } catch (e: SecurityException) {
            throw RuntimeException("Invalid JWT Token", e)
        } catch (e: MalformedJwtException) {
            throw RuntimeException("Invalid JWT Token", e)
        } catch (e: ExpiredJwtException) {
            throw RuntimeException("Expired JWT Token", e)
        } catch (e: UnsupportedJwtException) {
            throw RuntimeException("Unsupported JWT Token", e)
        } catch (e: IllegalArgumentException) {
            throw RuntimeException("JWT claims string is empty.", e)
        }
        throw RuntimeException("확인되지 않은 인증 오류")
    }


}