package com.vanpine.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vanpine.Entity.PO.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectList(LambdaQueryWrapper<User> userLambdaQueryWrapper, ArrayList<Integer> integers);
}
