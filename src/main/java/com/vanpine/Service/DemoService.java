package com.vanpine.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vanpine.Entity.PO.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface DemoService extends IService<User> {

    User getByUserName(String username);

    List<User> ownCreateFunction(@Param("ew") LambdaQueryWrapper<User> userLambdaQueryWrapper, ArrayList<Integer> integers);
}
