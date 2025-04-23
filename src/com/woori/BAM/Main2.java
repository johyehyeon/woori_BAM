package com.woori.BAM;

public class Main2 {
	public static void main(String[] args) {
		
	String a = "asd";
	String b = "asd";
	
	System.out.println( a == b);  // 주소값이 같은가?
	System.out.println(a.equals(b)); // a.b 가진값이 같은가?
	//a 와 b는 같은 주소값이 같다. 
	
	String c = new String("asd");
	String d = new String("asd");
	// c와 d는 각각의 객체이며 주소값이 다르다.
	
	System.out.println( d == c);  // 주소값이 같은가?
	System.out.println(c.equals(d)); // a.b 가진값이 같은가? 
	// equals는 boolean값을 가진 메소드다
	
	
	
	}
}
