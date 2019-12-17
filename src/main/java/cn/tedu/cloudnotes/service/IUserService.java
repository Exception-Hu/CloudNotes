package cn.tedu.cloudnotes.service;

import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.ex.InsertException;
import cn.tedu.cloudnotes.service.ex.NicknameNotFoundException;
import cn.tedu.cloudnotes.service.ex.PasswordNotFoundException;
import cn.tedu.cloudnotes.service.ex.UpdateException;
import cn.tedu.cloudnotes.service.ex.UsernameNotFoundException;

/**
 * 业务层实现接口
 */
public interface IUserService {
	
	/**
	 * 用户注册功能
	 * @param user 封装了用户信息的实体类
	 * @throws UsernameNotFoundException 用户名已存在异常
	 * @throws NicknameNotFoundException 用户昵称已存在异常
	 * @throws InsertException 添加异常
	 */
	void reg(User user)throws UsernameNotFoundException,NicknameNotFoundException,InsertException;
	
	/**
	 * 用户登入功能
	 * @param username 用户名
	 * @param password  用户密码
	 * @return 封装了用户信息的实体类
	 * @throws UsernameNotFoundException 用户错误异常
	 * @throws PasswordNotFoundException 密码错误异常
	 */
	User login(String username,String password)throws UsernameNotFoundException,PasswordNotFoundException;
	
	/**
	 * 用户更新数据
	 * @param id 用户id
	 * @param password 用户密码
	 * @throws PasswordNotFoundException 密码不正确异常
	 * @throws UpdateException 跟新数据失败异常
	 */
	void changePassword(Integer id,String oldPassword,String newPassword)throws PasswordNotFoundException,UpdateException;
	
	/**
	 * 用户更新信息
	 * @param id 用户id
	 * @param user 封装了用户的实体类
	 * @return
	 * @throws UpdateException
	 */
	void changeInfo(Integer id,User user)throws UpdateException,UsernameNotFoundException;
	
	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @return
	 * @throws UsernameNotFoundException
	 */
	User getByid(Integer id)throws UsernameNotFoundException;
}
