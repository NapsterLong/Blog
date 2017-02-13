package com.napster.service.admin;

import com.napster.model.User;

/**
 * 用户Service
 */
public interface UserService {

    User getByUserId(String userId);
}
