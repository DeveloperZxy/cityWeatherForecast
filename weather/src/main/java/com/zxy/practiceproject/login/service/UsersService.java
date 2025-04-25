package com.zxy.practiceproject.login.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.practiceproject.login.pojo.dto.UserLoginDTO;
import com.zxy.practiceproject.login.pojo.dto.UserLoginVO;

import java.util.List;

public interface UsersService {
    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    UserLoginVO login(UserLoginDTO userLoginDTO);

    List<Tree<String>> getPermissions(String id);
}
