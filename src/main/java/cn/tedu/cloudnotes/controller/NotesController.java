package cn.tedu.cloudnotes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.service.INotesService;
import cn.tedu.cloudnotes.util.JsonReult;

@RestController
@RequestMapping("notes")
public class NotesController extends BaseController{
	
	@Autowired
	private INotesService service;
	
	@RequestMapping("insert")
	public JsonReult<Void> insertNotes(Message message,HttpSession session){
		Integer userId = SessionId(session);
		service.insert(userId, message);
		return new JsonReult<Void>(SUCCESS);
	}
	
	@GetMapping("browse-message")
	public JsonReult<List<NotesMessage>> browseNotes(HttpSession session){
		Integer id = SessionId(session);
		List<NotesMessage> message = service.browseNotes(id);
		return new JsonReult<List<NotesMessage>>(SUCCESS,message);
	}
	
	
	/**
	 * 返回前段的json表格数据
	 * @param session
	 * @return
	 */
	@RequestMapping("datagrid")
	public List<NotesMessage> datagridJson(HttpSession session){
		Integer id = SessionId(session);
		//查询 
		List<NotesMessage> mwMediaLiveVideosList = service.browseNotes(id);
		return mwMediaLiveVideosList;
	}
	
	
	/** * 
	 * @param page 当前的页数 
	 * @param rows 每页记录大小 
	 * @return */

	@RequestMapping(value = "/getLiveVideoInfo",method = RequestMethod.POST)
	public Map getLiveVideoInfo(Integer page, Integer rows,HttpSession session){     
		Integer id = SessionId(session);
		//查询所有数据    
		List<NotesMessage> mwMediaLiveVideosList = service.browseNotes(id);    
		//查询总记录数    
		Long total = (long) mwMediaLiveVideosList.size();
		//展示分页集合    
		List<NotesMessage> mwMediaLiveVideos = new ArrayList<>();     
		for (int i = 0; i < mwMediaLiveVideosList.size(); i++)    {        
			//当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数        
			//第一次传过来的rows 是10 page是1        
			if (i >= (page - 1) * rows && i < page * rows)        {            
				//符合当前页的数据添加到展示分页集合中            
				mwMediaLiveVideos.add(mwMediaLiveVideosList.get(i));        
				}    
			}    
		Map<String,Object> result = new HashMap<String,Object>();    
		result.put("total", total);    
		result.put("rows", mwMediaLiveVideos);    
		return result; 
		}
			
		

}
