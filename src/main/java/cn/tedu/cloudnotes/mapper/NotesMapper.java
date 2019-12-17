package cn.tedu.cloudnotes.mapper;

import java.util.List;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;

/**
 * 用户笔记持久层
 * @author Administrator
 *
 */
public interface NotesMapper {
	/**
	 * 用户添加笔记
	 * @param message 封装了用户笔记的信息
	 * @return 受形象的行数
	 */
	Integer insertNotes(Message message);
	
	/**
	 * 用户查看笔记
	 * @return
	 */
	List<NotesMessage> browseNotes(Integer id);
	

}
