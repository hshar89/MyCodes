package com.designpatterns.observor.model;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;

public class EmailTopicSubscriber implements Observer{
	
	private String name;
	
	//Reference to our subject
	private Subject topic;
	
	public EmailTopicSubscriber(String name) {
		this.name = name;
	}
	@Override
	public void update() {
		String msg = (String)topic.getUpdate(this);
		if(msg==null) {
			System.out.println(name+" no new updates found on this topic ");
		}else {
			System.out.println(name+" retrieving message "+msg);
		}
	}

	@Override
	public void setSubject(Subject subject) {
		this.topic = subject;
	}

}
