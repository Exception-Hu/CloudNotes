package cn.tedu.cloudnotes.service;

import java.util.List;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.service.ex.DeleteException;
import cn.tedu.cloudnotes.service.ex.InsertException;
import cn.tedu.cloudnotes.service.ex.NotesNotFoundException;

/**
 * 用户笔记业务层实现接口
 * @author Administrator
 *
 */
public interface INotesService {
	
	/**
	 * 用户添加笔记
	 * @param message 封装了用户笔记的实体类
	 * @throws InsertException 添加出现的异常
	 */
	void insert(Integer userId,Message message)throws InsertException;
	
	/**
	 * 查看所有笔记
	 * @return 封装了用户笔记的实体类的List集合
	 */
	List<NotesMessage> browseNotes(Integer id)throws NotesNotFoundException;
	
	
	
}
