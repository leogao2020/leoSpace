package com.demo.thinkquery.dto;

import com.demo.thinkquery.dto.data.UserDTO;
import lombok.Data;

@Data
public class UserAddCmd {
    private UserDTO userDTO;
}
