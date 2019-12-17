package cn.tedu.cloudnotes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.mapper.UserMapper;
import cn.tedu.cloudnotes.service.IUserService;
import cn.tedu.cloudnotes.service.ex.InsertException;
import cn.tedu.cloudnotes.service.ex.NicknameNotFoundException;
import cn.tedu.cloudnotes.service.ex.PasswordNotFoundException;
import cn.tedu.cloudnotes.service.ex.UpdateException;
import cn.tedu.cloudnotes.service.ex.UsernameNotFoundException;

/**
 * 业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired 
	private UserMapper userMapper;
	
	/**
	 * 用户注册功能
	 */
	@Override
	public void reg(User user) throws UsernameNotFoundException, NicknameNotFoundException, InsertException {
		//查询用户名
		String username = user.getUsername();
		//查询用户昵称
		String nickname = user.getNickname();				
		//查看用户名是否存在
		User resultUsername = userMapper.findByUsername(username);
		//查看用户昵称是否存在
		User resultNickname = userMapper.findByNickname(nickname);
		//是：UsernameNotFoundException	
		if(resultUsername!=null) {			
			throw new UsernameNotFoundException("用户名已存在");
		}
		//是：NicknameNotFoundException
		if(resultNickname!=null) {			
			throw new NicknameNotFoundException("用户昵称已存在");
		}
		//用户类型设置为普通用户
		user.setRole(1);
		//添加数据
		Integer row =  userMapper.insert(user);
		//查看返回值是否为1
		if(!row.equals(1)) {
			//不为1：InsertException
			throw new InsertException("注册异常！请联系管理员");
		}
	}

	/**
	 * 用户登入功能
	 */
	@Override
	public User login(String username, String password) throws UsernameNotFoundException, PasswordNotFoundException {
		//根据用户名查询用户信息
		User user = userMapper.findByUsername(username);
		//如果为null，UsernameNotFoundException
		if(user==null) {
			throw new UsernameNotFoundException("用户名或用户密码错误");
		}
		//获取用户密码
		String databasePassword = user.getPassword();
		//数据库密码与用户密码进行匹配
		//如果没有匹配成功,PasswordNotFoundException
		if(!databasePassword.equals(password)) {
			throw new PasswordNotFoundException("用户名或用户密码错误");
		}
		//为了账户安全把密码设置为null
		user.setPassword(null);
		//返回 user
		return user;
	}

	/**
	 * 用户更新密码
	 */
	@Override
	public void changePassword(Integer id,String oldPassword,String newPassword) throws PasswordNotFoundException, UpdateException {
		//根据用户id查看用户数据
		User user = userMapper.findById(id);
		//获取用户密码
		String password = user.getPassword();
		//新密码与老密码比对
		//如果没有匹配成功，PasswordNotFoundException
		if(!password.equals(oldPassword)) {
			throw new PasswordNotFoundException("您输入的密码和您之前的密码不匹配");
		}
		//更改信息
		Integer row = userMapper.updatePassword(id, newPassword);
		//如果返回行数不为1，UpdateException
		if(!row.equals(1)) {
			throw new UpdateException("修改密码异常！请联系管理员");
		}
	}

	/**
	 * 用户更新数据
	 */
	@Override
	public void changeInfo(Integer id, User user) throws UpdateException {
		//根据id查看是否有用户数据
		User result = userMapper.findById(id);
		//如果为null,UsernameNotFoundException
		if(result==null) {
			throw new UsernameNotFoundException("用户数据不存在");
		}
		//把id存入user中
		 user.setId(id);
		 //更改信息
		 Integer row = userMapper.updateMessage(user);
		 if(!row.equals(1)) {
			 throw new UpdateException("修改信息异常！请联系管理员");
		 }
	}

	/**
	 * 获取用户信息
	 */
	@Override
	public User getByid(Integer id) throws UsernameNotFoundException {
		//根据用户id查询用户数据
		User user = userMapper.findById(id);
		//如果为null，UsernameNotFoundException
		if(user==null) {
			throw new UsernameNotFoundException("数据不存在");
		}
		//把id设置为null
		user.setPassword(null);
		user.setId(null);
		user.setRole(null);
		return user;
	}
	
	
	
	
	


}
