package com.xdclass.net.onlinexdclass.utils;

import com.xdclass.net.onlinexdclass.entity.User;
import com.xdclass.net.onlinexdclass.exception.ExceptionAdvice;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jwt工具类 注意点: 1、生成的token, 是可以通过base64进行解密出明文信息 2、base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3、无法作废已颁布的token，除非改秘钥
 */
public class JWTUtils {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

  /** 过期时间，一周 */
  private static final long EXPIRE = 60000 * 60 * 24 * 7;
  // private  static final long EXPIRE = 1;

  /** 加密秘钥 */
  private static final String SECRET = "xdclass.net168";

  /** 令牌前缀 */
  private static final String TOKEN_PREFIX = "xdclass";

  /** subject */
  private static final String SUBJECT = "xdclass";

  /**
   * 根据用户信息，生成令牌
   *
   * @param user
   * @return
   */
  public static String geneJsonWebToken(User user) {
    String token =
        Jwts.builder()
            .setSubject(SUBJECT)
            .claim("head_img", user.getHeadImg())
            .claim("id", user.getId())
            .claim("name", user.getName())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    return TOKEN_PREFIX + token;
  }

  /**
   * 校验token的方法
   *
   * @param token
   * @return
   */
  public static Claims checkJWT(String token) {
    try {
      return Jwts.parser()
          .setSigningKey(SECRET)
          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
          .getBody();
    } catch (Exception e) {
      return null;
    }
  }
}
