package com.demo.thinkquery.user.convertor;

import com.demo.thinkquery.domain.user.User;
import com.demo.thinkquery.user.UserDO;

public class UserConvertor {
    public static UserDO convert2UserDo(User user) {
        UserDO userDO = new UserDO();
        userDO.setId(user.getId());
        userDO.setUsername(user.getUsername());
        userDO.setName(user.getName());
        userDO.setPhoneNo(user.getPhoneNo());
        userDO.setGender(user.getGender());
        userDO.setBirthday(user.getBirthday());
        userDO.setDescription(user.getDescription());
        return userDO;
    }

    public static User convert2User(UserDO userDO) {
        User user = new User();
        user.setId(userDO.getId());
        user.setUsername(userDO.getUsername());
        user.setName(userDO.getName());
        user.setPhoneNo(userDO.getPhoneNo());
        user.setGender(userDO.getGender());
        user.setBirthday(userDO.getBirthday());
        user.setDescription(userDO.getDescription());
        return user;
    }
}
