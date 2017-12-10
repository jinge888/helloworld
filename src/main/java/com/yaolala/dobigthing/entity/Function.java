package com.yaolala.dobigthing.entity;

import com.yaolala.dobigthing.common.BaseEntity;

/**
 * 功能表
 * @author rachelyao
 *
 */
public class Function extends BaseEntity{
	
	private String name;
	private Long parentId;
	private String url;
	private Integer serialNum;// 
	private Integer accordion;//

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	public Integer getAccordion() {
		return accordion;
	}
	public void setAccordion(Integer accordion) {
		this.accordion = accordion;
	}
	
}