package de.metacoder.remotingtest.spring;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
}
