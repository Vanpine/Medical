package com.vanpine.Controller;

import com.vanpine.Entity.PO.User;
import com.vanpine.Entity.Result;
import com.vanpine.Service.DemoService;
import com.vanpine.Util.JwtUtil;
import com.vanpine.Util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Api(tags = "登录接口")
public class LoginController {
    private final DemoService demoService;
    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result<String> register(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) throws Exception {
        if (demoService.getByUserName(username) != null) {
            return Result.error("用户已存在，请重新注册！！！");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.GetMD5Code(password));
        boolean temp = demoService.save(user);
        return Result.success(temp ? "注册成功" : "注册失败");
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<String> login(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) throws Exception {
        User byUserName = demoService.getByUserName(username);
        if (byUserName == null) {
            return Result.error("用户名不存在");
        }
        if (!MD5Util.GetMD5Code(password).equals(byUserName.getPassword())) {
            return Result.error("用户密码错误,请重新输入");
        }
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", byUserName.getId());
        claims.put("username", byUserName.getUsername());
        System.out.println(claims);
        String token = JwtUtil.genToken(claims);
        stringRedisTemplate.opsForValue().set("token", token, 60, TimeUnit.SECONDS);
        return Result.success(token);
    }
}
