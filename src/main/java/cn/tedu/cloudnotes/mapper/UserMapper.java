package cn.tedu.cloudnotes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.cloudnotes.entity.User;

/**
 * 持久层
 */
public interface UserMapper {

	/**
	 * 插入用户数据
	 * 
	 * @param user 封装了用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);

	/**
	 * 根据用户名查询用户数据
	 * 
	 * @param username 用户名
	 * @return 封装了用户数据
	 */
	User findByUsername(String username);

	/**
	 * 根据用户昵称查询用户数据
	 * 
	 * @param username 用户名
	 * @return 封装了用户数据
	 */
	User findByNickname(String nickname);

	/**
	 * 根据用户id查询用户数据
	 * 
	 * @param id 用户id
	 * @return 封装了用户数据
	 */
	User findById(Integer id);

	/**
	 * 修改密码
	 * 
	 * @param password 用户密码
	 * @return 受影响的行数
	 */
	Integer updatePassword(@Param("id") Integer id, @Param("password") String password);

	/**
	 * 修改信息
	 * 
	 * @param user 封装了用户实体类
	 * @return
	 */
	Integer updateMessage(User user);


}
