package cn.tedu.cloudnotes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.IUserService;
import cn.tedu.cloudnotes.util.JsonReult;
/**
 * 控制器层
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{
	@Autowired
	private IUserService service;
	
	/**
	 * 用户注册
	 * @param user 封装了用户数据
	 * @return 前段页面所需要的状态
	 */
	@RequestMapping("reg")
	public JsonReult<Void> reg(User user){
		//调用业务层信息
		service.reg(user);
		return new JsonReult<Void>(SUCCESS);
	}
	
	/**
	 * 用户登入
	 * @param username 用户名
	 * @param password 用户密码
	 * @param session 下发id和username
	 * @return 返回状态
	 */
	@PostMapping("login")
	public JsonReult<User> logon(String username,String password,HttpSession session){
		//调用业务层信息
		User user = service.login(username, password);
		session.setAttribute("username", username);
		session.setAttribute("id", user.getId());
		return new JsonReult<User>(SUCCESS, user);
	}
	
	/**
	 * 用户修改密码
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @param session 获取id
	 * @return 返回状态
	 */
	@RequestMapping("change-password")
	public JsonReult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
		Integer id = SessionId(session);
		service.changePassword(id, oldPassword, newPassword);
		return new  JsonReult<Void>(SUCCESS);
	}
	
	/**
	 * 修改用户信息
	 * @param user 封装了用户数据的实体类
	 * @param session 获取id
	 * @return 状态
	 */
	@RequestMapping("change-info")
	public JsonReult<Void> changeInfo(User user,HttpSession session){
		Integer id = SessionId(session);
		service.changeInfo(id, user);
		return new JsonReult<Void>(SUCCESS);
	}
	
	@GetMapping("get-by-id")
	public JsonReult<User> getById(HttpSession session){
		User user = service.getByid(SessionId(session));
		return new JsonReult<User>(SUCCESS,user);
	}
	
	@RequestMapping("out")
	public JsonReult<User> getOutId(HttpSession session){
		session.removeAttribute("id");
		return new JsonReult<User>(SUCCESS);
	}
	
}
