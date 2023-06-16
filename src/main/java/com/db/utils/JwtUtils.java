package com.db.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.db.entity.Tenant;


import java.util.Calendar;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-24 14:23
 */
public class JwtUtils {
    private static long expire = 604800;
    // 32为密钥
    private static String secret = "248abd887c7e40ce84b25ef253e6ff8d";

    // 普通用户的加密
    public static String generateToken(String username){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 30); //默认七天过期
        String token = JWT.create()
                .withClaim("username", username)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public static DecodedJWT getClaimsByToken(String token){
        // 创建验证对象
        JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
        try{
            DecodedJWT verify = build.verify(token);
            return verify;
        }catch (Exception e){
            return null;
        }
    }
}
