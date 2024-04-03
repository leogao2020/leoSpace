package com.demo.thinkquery.user;

import com.demo.thinkquery.domain.user.User;
import com.demo.thinkquery.domain.user.gateway.UserGateway;
import com.demo.thinkquery.user.convertor.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserGatewayImpl implements UserGateway {


    @Autowired
    public UserMapper userMapper;

    @Override
    public User save(User user) {
        try {
            UserDO userDO = UserConvertor.convert2UserDo(user);
            // 假设 userMapper 已经采用了参数化查询，这里主要为了展示异常处理
            int effectRows = userMapper.insert(userDO);
            if (effectRows > 0) {
                return user;
            } else {
                // 插入失败的处理逻辑
                // 可以根据需要记录日志、抛出自定义异常等
                //log.error("User insertion failed for user: " + user.toString());
                // 根据业务需求，这里可以选择抛出异常或返回特定的错误信息
                return null;
            }
        } catch (Exception e) {
            // 异常处理逻辑
            //log.error("Exception occurred during user insertion: ", e);
            // 根据业务需求处理异常，比如可以抛出自定义异常
           return null;
        }
    }

    @Override
    public List<User> findAll() {
        // 尝试查询用户列表，并进行异常捕获和空值检查
        List<UserDO> userList;
        try {
            userList = userMapper.findAll();
        } catch (Exception e) {
            // 日志记录异常，这里简单返回空列表，也可以考虑抛出自定义异常或记录日志后重新抛出当前异常
            //Logger.error("Failed to fetch user list", e);
            return Collections.emptyList();
        }

        // 空值检查
        if (userList == null) {
            // Logger.error("User list is null");
            return Collections.emptyList();
        }

        // 使用流进行转换，考虑到转换操作可能的复杂性，这里保持使用串行流
        List<User> users = userList.parallelStream().map(UserConvertor::convert2User).collect(Collectors.toList());
        return users;
    }
}
