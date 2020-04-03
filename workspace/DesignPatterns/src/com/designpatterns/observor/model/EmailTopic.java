package com.designpatterns.observor.model;

import java.util.ArrayList;
import java.util.List;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;

public class EmailTopic implements Subject{
	
	private List<Observer> observers;
	private String message;
	
	private final String topicName;
	
	public EmailTopic() {
		this.observers = new ArrayList<>();
		topicName ="Email Topic";
	}
	
	public String getSubjectName() {
		return topicName;
	}
	@Override
	public void register(Observer observer) {
		if(observer==null) {
			throw new NullPointerException("Null object/Observer");
		}
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
		
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);	
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update();
		}
		
	}

	@Override
	public Object getUpdate(Observer observer) {
		return this.message;
	}
	
	public void postMessage(String msg) {
		System.out.println("Message posted to my topic : "+msg);
		this.message = msg;
		notifyObservers();
	}

}
