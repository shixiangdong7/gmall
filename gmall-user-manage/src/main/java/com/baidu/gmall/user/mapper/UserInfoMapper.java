package com.baidu.gmall.user.mapper;


import com.baidu.gmall.bean.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {

    List<UserInfo> findAllUser();
}
