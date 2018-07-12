package com.dreawer.customer.service;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreawer.customer.domain.Customer;
import com.dreawer.customer.domain.Sns;
import com.dreawer.customer.domain.User;
import com.dreawer.customer.lang.UserStatus;
import com.dreawer.customer.persistence.CustomerDao;
import com.dreawer.customer.persistence.SnsDao;
import com.dreawer.customer.persistence.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao; // 用户信息DAO
    
    @Autowired
    private CustomerDao customerDao; // 客户信息DAO
    
    @Autowired
    private SnsDao snsDao;    //社交媒体dao
    
    /**
     * 获取用户。
     * @param id 用户ID号。
     * @return 用户。如果用户存在则返回用户对象，否则返回 null。
     */
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }
    
    /**
     * 保存用户信息。
     * @param sns 第三方媒体信息。
     * @param user 用户信息。
     */
	public void addSnsUser(Sns sns, User user, Customer customer) {
		// 组建用户权限
		userDao.save(user);
		
		// 新建第三方用户信息
		sns.setUser(user);
		sns.setCreater(user);
		snsDao.save(sns);
		
		// 新建客户信息
		customerDao.save(customer);
	}
	
	/**
	 * 新增用户。
	 * @param user 用户信息。
	 */
	public void addUser(User user, Customer customer) {
		// 组建用户权限
		userDao.save(user);
		
		// 新建客户信息
		customer.setId(user.getId());
		customerDao.save(customer);
	}
	
	/**
	 * 修改用户密码。
	 * @param user
	 * @return
	 */
	public int updatePassword(User user) {
		return userDao.updatePassword(user);
	}
	
	/**
	 * 修改用户基本信息。
	 * @param user 用户信息。
	 * @return 成功处理的记录数。
	 */
	public void updateBasic(User user) {
		userDao.updateBasic(user);
	}

	/**
	 * 通过邮箱查找用户。
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email, String appId) {
		return userDao.findUserByEmail(email, appId);
	}

	/**
	 * 更新用户状态。
	 * @param user 用户信息。
	 * @param status 用户状态。
	 */
	public void updateStatus(User user, UserStatus status) {
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userDao.updateStatus(user, status);
		customerDao.updateStatus(new Customer(user.getId()), status);
		
	}

	/**
	 * 通过手机号查找用户。
	 * @param phoneNumber 手机号。
	 * @param appId 
	 * @return
	 */
	public User findUserByPhone(String phoneNumber, String appId) {
		return userDao.findUserByPhone(phoneNumber, appId);
	}


}
