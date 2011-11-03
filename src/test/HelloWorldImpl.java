package test;

import javax.jws.WebService;

@WebService(endpointInterface = "test.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}

}