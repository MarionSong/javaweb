package cn.tedu.spring_01;

public class HelloService {
	private HelloService() {
		System.out.println("HelloService()");
	}
	public void init() {
		System.out.println("init()");
	}
	public void sayHello(String msg) {
		System.out.println("hello"+msg);
	}
	public void destory() {
		System.out.println("destory");
	}
	
	
}
