package cn.tedu.cloudnotes.service;

import java.util.List;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.ex.DeleteException;
import cn.tedu.cloudnotes.service.ex.NotesNotFoundException;
import cn.tedu.cloudnotes.service.ex.PasswordNotFoundException;
import cn.tedu.cloudnotes.service.ex.RoleTypeMismatchException;
import cn.tedu.cloudnotes.service.ex.UsernameNotFoundException;

public interface IAdminService {
	
	/**
	 * 根据管理员名字查询用户数据
	 * @param adminname 管理员
	 * @return 封装了用户数据的实体类
	 */
	User adminLogin(String adminname, String password)
			throws RoleTypeMismatchException, UsernameNotFoundException, PasswordNotFoundException;
	
	/**
	 * 查询用户的全部笔记
	 * @return 封装了用户笔记的实体类集合
	 * @throws NotesNotFoundException 没有用户笔记异常
	 */
	List<NotesMessage> seekNotesMessages()throws NotesNotFoundException;
	
	/**
	 * 根据用户笔记id删除数据
	 * @param id 用户信息id
	 * @throws DeleteException 删除异常
	 */ 
	void removeByid(Integer id)throws DeleteException;
}
