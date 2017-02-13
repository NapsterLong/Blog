package com.napster.service.admin;

import com.napster.common.response.ResponseResult;
import com.napster.enums.ResultCodeEnum;
import com.napster.model.User;
import com.napster.util.AESUtil;
import com.napster.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 登陆Service
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Value("${loginKey}")
    private String loginKey;

    @Override
    public ResponseResult<String> loginIn(User user) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        User resultUser;
        try {
            String userId = user.getUserId();
            String password = user.getUserPassword();
            //查询用户是否存在
            resultUser = userService.getByUserId(userId);
            if (null == resultUser) {
                responseResult.setCode(ResultCodeEnum.ARGUMENT_ERROR);
                responseResult.setMessage("用户不存在");
                return responseResult;
            } else {
                //验证密码是否正确
                if (AESUtil.decrypt(resultUser.getUserPassword(), loginKey).equals(password)) {
                    responseResult.setCode(ResultCodeEnum.SUCCESS);
                } else {
                    responseResult.setCode(ResultCodeEnum.ARGUMENT_ERROR);
                    responseResult.setMessage("密码不正确");
                }
            }
        } catch (Exception e) {
            LogUtil.logError(e);
            responseResult.setCode(ResultCodeEnum.SYS_ERROR);
            responseResult.setMessage("系统错误");
        }
        return responseResult;
    }

}
