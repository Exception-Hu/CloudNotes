package cn.tedu.cloudnotes.usermapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void fandByUsername() {
		User user = mapper.findByUsername("admin");
		System.err.println(user);
	}
	
	@Test
	public void fandByNickname() {
		User user = mapper.findByNickname("管理");
		System.err.println(user);
	}
	
	@Test
	public void insert() {
		User user = new User();
		user.setRole(1);
		user.setUsername("zzz");
		user.setPassword("123");
		Integer rowsInteger = mapper.insert(user);
		System.out.println(rowsInteger);
	}
	
	@Test
	public void findByid() {
		User user = mapper.findById(4);
		System.err.println(user);
	}
	
	@Test
	public void updatePassword() {
		mapper.updatePassword(2, "123456");
	}
	
	@Test
	public void updateMessage() {
		User user = new User();
		user.setEmail("12365@163.com");
		user.setNickname("张三");
		user.setId(4);
		mapper.updateMessage(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
