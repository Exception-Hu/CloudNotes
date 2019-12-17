package cn.tedu.cloudnotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.cloudnotes.entity.SelectJson;
import cn.tedu.cloudnotes.mapper.Json;
import cn.tedu.cloudnotes.service.IJson;

@Service
public class JsonServerImpl implements IJson {
	
	@Autowired
	private Json json;

	@Override
	public List<SelectJson> selectJson() {
		
		return json.selectJson();
	}
	
}
