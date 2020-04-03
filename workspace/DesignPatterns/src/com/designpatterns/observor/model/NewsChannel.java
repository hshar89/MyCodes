package com.designpatterns.observor.model;

import java.util.ArrayList;
import java.util.List;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;

public class NewsChannel implements Subject {
	
	private List<Observer> observers;
	
	private String message;
	
	private final String topicName;
	
	public NewsChannel() {
		observers = new ArrayList<>();
		topicName= "News";
	}
	@Override
	public void register(Observer observer) {
		if(observer==null) {
			throw new IllegalArgumentException("Observer cannot be null");
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
		return message;
	}
	
	public void postMessage(String msg) {
		System.out.println("Message posted to my topic: "+msg);
		this.message = msg;
		notifyObservers();
	}
	@Override
	public String getSubjectName() {
		return topicName;
	}

}
