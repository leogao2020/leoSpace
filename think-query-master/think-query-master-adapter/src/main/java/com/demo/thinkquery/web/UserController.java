package com.demo.thinkquery.web;

import com.alibaba.cola.dto.MultiResponse;
import com.demo.thinkquery.api.UserServiceI;
import com.demo.thinkquery.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserServiceI userService;

    @GetMapping(value = "/users")
    public MultiResponse<UserDTO> queryAllUsers() {
        return userService.queryAll();
    }
}
