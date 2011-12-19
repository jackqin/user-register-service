package com.colorcc.user.register.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.colorcc.common.annotation.ColorccMarshalAnnotation;

@XmlRootElement
@ColorccMarshalAnnotation("beanList")
public class BeanList<T> {

	private List<T> beanList;

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	public void addBeanList(T t) {
		this.beanList.add(t);
	}

}
