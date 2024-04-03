package com.amos.think.domain.user;

import lombok.Data;

import java.time.LocalDate;

/**
 * User Domain
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Data
public class UserEntity {

    private Long id;

    /**
     * 用户名
     */
    private UserName username;
    /**
     * 密码
     */
    private UserPassword password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserName getUsername() {
        return username;
    }

    public void setUsername(UserName username) {
        this.username = username;
    }

    public UserPassword getPassword() {
        return password;
    }

    public void setPassword(UserPassword password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
