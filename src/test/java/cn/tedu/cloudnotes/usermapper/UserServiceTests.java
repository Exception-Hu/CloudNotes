package cn.tedu.cloudnotes.usermapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	@Autowired
	private UserServiceImpl service;
	
	@Test
	public void insert() {
		try {
			User user = new User();
			user.setUsername("cAc");
			user.setPassword("123");
			user.setEmail("zzz@123.com");
			user.setNickname("ZZZ");
			service.reg(user);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void login() {
		try {
			User user = service.login("zzz", "123");
			System.err.println(user);
		}catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test 
	public void changePassword() {
		try {
			service.changePassword(2, "123456", "123");
		}catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeInfo() {
		try {
			User user = new User();
			user.setEmail("1236@162.com");
			user.setNickname("Java");
			service.changeInfo(6, user);
		}catch(Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByid() {
		try {
			User user = service.getByid(6);
			System.err.println(user);
		}catch(Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
}
