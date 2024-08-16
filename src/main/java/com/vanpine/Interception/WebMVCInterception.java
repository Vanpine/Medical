package com.vanpine.Interception;


import com.vanpine.Util.JwtUtil;
import com.vanpine.Util.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class WebMVCInterception implements HandlerInterceptor {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从前端获取Token
        String token = request.getHeader("Authorization");
        // 如果获取不到token
        if (token == null) {
            response.setStatus(401);
            return false;
        }
        // 二级校验
        String RedisCacheToken = stringRedisTemplate.opsForValue().get("token");
        if (!token.equals(RedisCacheToken)) {
            response.setStatus(401);
            return false;
        } else {
            // 删除原来的Token
            stringRedisTemplate.delete("token");
            // 更新token时间 也就是重新设置token
            stringRedisTemplate.opsForValue().set("token", token, 30, TimeUnit.MINUTES);
            Map<String, Object> userInfo = JwtUtil.parseToken(token);
            // 存入线程池当中
            ThreadLocalUtil.set(userInfo);
            return true;
        }

        
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.delete();
    }
}
