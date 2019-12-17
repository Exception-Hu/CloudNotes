package cn.tedu.cloudnotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.mapper.AdminMapper;
import cn.tedu.cloudnotes.service.IAdminService;
import cn.tedu.cloudnotes.service.ex.DeleteException;
import cn.tedu.cloudnotes.service.ex.NotesNotFoundException;
import cn.tedu.cloudnotes.service.ex.PasswordNotFoundException;
import cn.tedu.cloudnotes.service.ex.RoleTypeMismatchException;
import cn.tedu.cloudnotes.service.ex.UsernameNotFoundException;

/**
 * 管理员业务层
 * @author Administrator
 *
 */
@Service
public class AdminServiceImpl implements IAdminService{
	
	/**
	 * 管理员登入
	 */
	@Autowired
	private AdminMapper mapper;
	@Override
	public User adminLogin(String adminname,String password)
			throws RoleTypeMismatchException, UsernameNotFoundException, PasswordNotFoundException {
		//根据管理员的名字查询数据
		User user = mapper.findByUsername(adminname);
		//返回结果为null，UsernameNotFoundException
		if(user==null) {
			throw new UsernameNotFoundException("用户或密码错误");
		}
		//查看role是否为1，1用户，0管理员
		if(new Integer(1).equals(user.getRole())) {
			throw new UsernameNotFoundException("您输入的用户不是管理员");
		}
		//管理员密码与数据中的密码进行比对
		//如果不等于，PasswordNotFoundException
		if(!user.getPassword().equals(password)) {
			throw new PasswordNotFoundException("用户或密码错误");
		}
		//把管理员密码设置为null
		user.setPassword(null);
		//返回user
		return user;
	}
	
	/**
	 * 管理员查看全部笔记
	 */
	@Override
	public List<NotesMessage> seekNotesMessages() throws NotesNotFoundException {
		List<NotesMessage> notesMessages = mapper.findByAll();
		if(notesMessages==null) {
			throw new NotesNotFoundException("没有用户笔记");
		}
		return notesMessages;
	}
	
	/**
	 * 根据用户笔记id删除数据
	 */
	@Override
	public void removeByid(Integer id) throws DeleteException {
		NotesMessage notesMessage = mapper.findByid(id);
		if(notesMessage==null) {
			throw new NotesNotFoundException("没有用户笔记");
		}
		Integer row = mapper.deleteGetId(id);
		if(!new Integer(1).equals(row)) {
			throw new DeleteException("删除失败！请联系管理员");
		} 
	}
	
}
