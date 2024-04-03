package com.demo.thinkquery.domain.user.gateway;

import com.demo.thinkquery.domain.user.User;

import java.util.List;

public interface UserGateway {
    /**
     * 保存用户
     *
     * @param user User Domain
     * @return 用户实体
     */
    User save(User user);

    /**
     * 获取用户信息
     *
     * @return 用户实体清单
     */
    List<User> findAll();
}
