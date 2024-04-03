package com.demo.thinkquery.user;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.demo.thinkquery.api.UserServiceI;
import com.demo.thinkquery.dto.data.UserDTO;
import com.demo.thinkquery.user.executor.query.UserListQryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserServiceI {

    @Resource
    public UserListQryExe userListQryExe;

    @Override
    public MultiResponse<UserDTO> queryAll() {
        return userListQryExe.execute();
    }
}
