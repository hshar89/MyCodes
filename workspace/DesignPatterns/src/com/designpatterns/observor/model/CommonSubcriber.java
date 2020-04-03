package com.designpatterns.observor.model;

import java.util.ArrayList;
import java.util.List;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;

public class CommonSubcriber implements Observer {
	
	private String name;
	
	private List<Subject> subcribedSubjects;
	
	public CommonSubcriber(String name) {
		this.name = name;
		subcribedSubjects = new ArrayList<>();
	}
	@Override
	public void update() {
	for(Subject sub: subcribedSubjects) {
		String msg = (String)sub.getUpdate(this);
		if(msg!=null) {
			System.out.println(sub.getSubjectName()+" posted this message "+msg);
		}else {
			System.out.println(sub.getSubjectName()+" has no new message ");
		}
	}
	}

	@Override
	public void setSubject(Subject subject) {
		if(subject==null) {
			throw new IllegalArgumentException("subject cannot be null");
		}
		if(!subcribedSubjects.contains(subject)) {
			subcribedSubjects.add(subject);
		}
	}

}
