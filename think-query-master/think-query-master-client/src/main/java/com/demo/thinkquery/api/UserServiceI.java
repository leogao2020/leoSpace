package com.demo.thinkquery.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.demo.thinkquery.dto.data.UserDTO;

public interface UserServiceI {
    MultiResponse<UserDTO> queryAll();
}
