package com.firecode.springcloudtest.userservice.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by 廖师兄
 * 2018-03-04 21:41
 */
@Data
@Entity
public class UserInfo {

	@Id
	private String id;

	private String username;

	private String password;

	private String openid;

	private Integer role;
}
