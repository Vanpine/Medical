package com.vanpine.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vanpine.Entity.PO.User;
import com.vanpine.Entity.Result;
import com.vanpine.Service.DemoService;
import com.vanpine.Util.MD5Util;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class demoController {

    private final DemoService demoService;

    @GetMapping("/select")
    public Result<List<User>> queryByUserId(@PathParam("id") Integer id) {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4);
        return Result.success(demoService.getBaseMapper().selectList(new LambdaQueryWrapper<User>().in(User::getId, integers)));
//        return Result.success(demoService.getBaseMapper().selectOne(new LambdaQueryWrapper<User>().like(User::getId, id)));
    }

    @GetMapping("/reservation")
    public Result<List<User>> queryByUserId() {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4);
        return Result.success(demoService.ownCreateFunction(new LambdaQueryWrapper<User>(), integers));
    }


}
