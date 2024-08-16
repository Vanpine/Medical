package com.vanpine.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vanpine.Entity.VO.UserVO;
import com.vanpine.Mapper.UserMapper;
import com.vanpine.Entity.PO.User;
import com.vanpine.Service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl extends ServiceImpl<UserMapper, User> implements DemoService {


    /*
     * 用户注册
     * */
    @Override
    public User getByUserName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    public List<User> ownCreateFunction(LambdaQueryWrapper<User> userLambdaQueryWrapper, ArrayList<Integer> integers) {
        return baseMapper.selectList(userLambdaQueryWrapper, integers);

    }
}
