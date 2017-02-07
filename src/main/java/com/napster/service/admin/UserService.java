package com.napster.service.admin;

import com.napster.common.response.ResponseResult;
import com.napster.model.User;

/**
 * 用户Service
 */
public interface UserService {

    /**
     * 管理员登陆
     *
     * @param user 用户信息
     * @return 登陆结果
     */
    ResponseResult<String> loginIn(User user);


}
