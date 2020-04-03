package com.designpatterns.observor.model;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;

public class NewsTopicSubscriber implements Observer {
	
	private Subject topic;
	
	private String name;
	
	public NewsTopicSubscriber(String name) {
		this.name= name;
	}
	@Override
	public void update() {
		String msg = (String)topic.getUpdate(this);
		if(msg==null) {
			System.out.println("No new update found "+name);
		}else {
			System.out.println(name+" retrieving msg "+msg);
		}

	}

	@Override
	public void setSubject(Subject subject) {
		this.topic = subject;
	}

}
