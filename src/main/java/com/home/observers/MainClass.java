package com.home.observers;

public class MainClass {

	public static void main(String[] args) {
		Subject subject1 = new TopicSubjectImpl();
		Subject subject2 = new TopicSubjectImpl();
		Subject subject3 = new TopicSubjectImpl();

		Observer observer1 = new ObserverImpl("observer1");
		Observer observer2 = new ObserverImpl("observer2");
		Observer observer3 = new ObserverImpl("observer3");

		observer1.subcribeSubject(subject1);
		observer2.subcribeSubject(subject2);
		observer3.subcribeSubject(subject3);

		subject1.postMessage("subject1");
		subject2.postMessage("subject2");
		subject3.postMessage("subject3");

		observer2.subcribeSubject(subject3);
		subject3.postMessage("lol");

	}
}
