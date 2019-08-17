package com.firecode.springcloudtest.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firecode.springcloudtest.userservice.dataobject.UserInfo;

/**
 * Created by 廖师兄
 * 2018-03-04 21:42
 */
public interface UserInfoRepostory extends JpaRepository<UserInfo, String> {

	UserInfo findByOpenid(String openid);
}
