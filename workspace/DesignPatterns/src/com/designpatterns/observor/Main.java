package com.designpatterns.observor;

import com.designpatterns.observor.interfaces.Observer;
import com.designpatterns.observor.interfaces.Subject;
import com.designpatterns.observor.model.CommonSubcriber;
import com.designpatterns.observor.model.EmailTopic;
import com.designpatterns.observor.model.EmailTopicSubscriber;
import com.designpatterns.observor.model.NewsChannel;
import com.designpatterns.observor.model.NewsTopicSubscriber;

public class Main {

	public static void main(String[] args) {
		
		EmailTopic topic = new EmailTopic();
		
		Observer first_ob = new EmailTopicSubscriber("first observer");
		
		Observer second_ob = new EmailTopicSubscriber("second observer");
		
		Observer third_ob = new EmailTopicSubscriber("third observer");
		
		topic.register(first_ob);
		topic.register(second_ob);
		topic.register(third_ob);
		
		first_ob.setSubject(topic);
		second_ob.setSubject(topic);
		third_ob.setSubject(topic);
		
		first_ob.update();
		third_ob.update();
		//Provider/Subject think of as a broadcaster
		
		topic.postMessage("hello subscribers ");
		
		NewsChannel news = new NewsChannel();
		Observer fourth_ob = new NewsTopicSubscriber("fourth observer");
		Observer fifth_ob = new NewsTopicSubscriber("fifth observer");
		Observer sixth_ob = new NewsTopicSubscriber("sixth observer");
		
		fourth_ob.setSubject(news);
		fifth_ob.setSubject(news);
		sixth_ob.setSubject(news);
		
		news.register(fourth_ob);
		news.register(fifth_ob);
		news.register(sixth_ob);
		news.postMessage("Hot gossip for the day");
		
		CommonSubcriber cs1 = new CommonSubcriber("First CommonSubscriber");
		cs1.setSubject(news);
		cs1.setSubject(topic);
		CommonSubcriber cs2 = new CommonSubcriber("Second CommonSubscriber");
		cs2.setSubject(news);
		news.register(cs1);
		news.register(cs2);
		topic.register(cs1);
		news.postMessage("Burning news coming through");
		
		topic.postMessage("Beware of spam emails ");
	}

}
