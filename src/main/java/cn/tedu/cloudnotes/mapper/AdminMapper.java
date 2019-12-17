package cn.tedu.cloudnotes.mapper;

import java.util.List;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;

/**
 * 管理员持久层
 * @author Administrator
 *
 */
public interface AdminMapper {
	
	/**
	 * 根据管理员的名字查询数据
	 * @param adminname 管理员
	 * @return 封装了用户数据的实体类
	 */
	User findByUsername(String adminname);
	
	/**
	 * 查询全部笔记信息
	 * @return
	 */
	List<NotesMessage> findByAll();
	
	/**
	 * 根据笔记id删除用户笔记
	 * @param id 用户笔记ids
	 * @return 受影响的行数
	 */
	Integer deleteGetId(Integer id);
	
	/**
	 * 根据笔记id查询笔记信息
	 * @param id 笔记id
	 * @return 封装了用户笔记实体类
	 */
	NotesMessage findByid(Integer id);
}
