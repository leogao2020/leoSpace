package com.demo.thinkquery.user.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.demo.thinkquery.domain.user.User;
import com.demo.thinkquery.domain.user.gateway.UserGateway;
import com.demo.thinkquery.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserListQryExe {

    @Autowired
    private UserGateway userGateway;
    public MultiResponse<UserDTO> execute() {
        List<User> list= userGateway.findAll();
        List<UserDTO> userDTOList = list.parallelStream().map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setUsername(user.getUsername());
                    userDTO.setName(user.getName());
                    userDTO.setPhoneNo(user.getPhoneNo());
                    userDTO.setGender(user.getGender());
                    userDTO.setBirthday(user.getBirthday());
                    userDTO.setDescription(user.getDescription());
                    return userDTO;
                }).collect(Collectors.toList());
        MultiResponse<UserDTO> multiResponse = new MultiResponse<>();
        multiResponse.setData(userDTOList);
        if(userDTOList!=null&&!userDTOList.isEmpty()) {
            multiResponse.setSuccess(true);
        }
        return multiResponse;
    }
}
