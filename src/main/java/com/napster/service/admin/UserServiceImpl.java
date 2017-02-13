package com.napster.service.admin;

import com.napster.mapper.UserMapper;
import com.napster.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new IllegalArgumentException("参数为空");
        }
        return userMapper.selectByUserId(userId);
    }
}
