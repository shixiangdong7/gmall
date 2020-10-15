package com.baidu.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.baidu.gmall.service.UserInfoService;
import com.baidu.gmall.bean.UserAddress;
import com.baidu.gmall.bean.UserInfo;
import com.baidu.gmall.user.mapper.UserAddressMapper;
import com.baidu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;


    @Override
    public List<UserInfo> findAllUser() {
        return userInfoMapper.findAllUser();
    }
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }



    @Override
    public UserInfo getUserInfoByName(String name) {
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoListByName(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoListByNickName(UserInfo userInfo) {
        return null;
    }

    @Override
    public void addUser(UserInfo userInfo) {

    }

    @Override
    public void updUser(UserInfo userInfo) {

    }

    @Override
    public void delUser(UserInfo userInfo) {

    }


    @Override
    public List<UserAddress> getUserAddressByUserId(String userId) {
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("userId",userId);

        return userAddressMapper.selectByExample(example);
    }

    @Override
    public List<UserAddress> getUserAddressByUserId(UserAddress userAddress) {
       return userAddressMapper.select(userAddress);
    }
}
