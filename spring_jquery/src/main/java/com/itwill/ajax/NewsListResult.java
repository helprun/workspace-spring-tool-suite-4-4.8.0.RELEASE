package com.itwill.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@XmlRootElement(name="result")
//@JacksonXmlRootElement(localName = "result")
public class NewsListResult {
	private int count;
	private List<News> newsList;
	
	@XmlElement(name="count")
//	@JacksonXmlProperty(localName = "count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElementWrapper(name="newsList")
	@XmlElement(name="news")
	@JacksonXmlElementWrapper(localName = "newsList")
	@JacksonXmlProperty(localName = "news")
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
	
}
