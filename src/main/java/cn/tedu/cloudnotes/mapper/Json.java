package cn.tedu.cloudnotes.mapper;

import java.util.List;

import cn.tedu.cloudnotes.entity.SelectJson;

public interface Json {
	/**
	 * 返回下拉框的信息
	 * @return
	 */
	List<SelectJson> selectJson();
}
