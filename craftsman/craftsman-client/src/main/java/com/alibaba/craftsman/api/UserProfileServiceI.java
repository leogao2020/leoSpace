package com.alibaba.craftsman.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.craftsman.dto.*;
import com.alibaba.craftsman.dto.clientobject.UserProfileCO;

/**
 * 用户档案服务接口，提供用户档案的增删改查等操作。
 */
public interface UserProfileServiceI {

    /**
     * 添加用户档案。
     *
     * @param cmd 添加用户档案的命令对象，包含添加用户档案所需的所有信息。
     * @return 响应对象，包含操作结果信息。
     */
    Response addUserProfile(UserProfileAddCmd cmd);

    /**
     * 更新用户档案。
     *
     * @param cmd 更新用户档案的命令对象，包含更新用户档案所需的所有信息。
     * @return 响应对象，包含操作结果信息。
     */
    Response updateUserProfile(UserProfileUpdateCmd cmd);

    /**
     * 刷新用户分数。
     *
     * @param cmd 刷新用户分数的命令对象，包含刷新分数所需的所有信息。
     * @return 响应对象，包含操作结果信息。
     */
    Response refreshScore(RefreshScoreCmd cmd);

    /**
     * 根据查询条件获取单个用户档案。
     *
     * @param qry 获取用户档案的查询对象，包含获取单个用户档案所需的查询条件。
     * @return 响应对象，包含查询结果的用户档案信息。
     */
    SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry);

    /**
     * 根据查询条件获取多个用户档案。
     *
     * @param qry 获取用户档案的查询对象，包含获取多个用户档案所需的查询条件。
     * @return 响应对象，包含查询结果的用户档案列表。
     */
    MultiResponse<UserProfileCO> listUserProfileBy(UserProfileListQry qry);
}

