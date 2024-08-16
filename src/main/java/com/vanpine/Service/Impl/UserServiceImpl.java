package com.vanpine.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vanpine.Entity.PO.User;
import com.vanpine.Mapper.UserMapper;
import com.vanpine.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
