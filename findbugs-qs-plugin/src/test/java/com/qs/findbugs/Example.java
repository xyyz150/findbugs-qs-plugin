package com.qs.findbugs;

public class Example {

	public static void main(String[] args) {
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
		System.out.println("system out");
	}
	
	public void run() {
		System.out.println("run");
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
