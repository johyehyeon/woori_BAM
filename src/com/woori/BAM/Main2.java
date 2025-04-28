package com.woori.BAM;

import java.util.Scanner;

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


//클래스에 변수선언하면 전역변수
public static void main(String[] args) {
//메소드 안에 변수선언하면 지역변수
	System.out.println("== 프로그램 시작 ==");
	Scanner sc = new Scanner(System.in); 
	// System 이란 클래스에 만들어진 in 소스를 가져다 씀
	// in는 필드이다. .을 누르면 system 안에 필드와 메소드들이 나옴
	// System.in 아규먼트로 불러오는 스태틱이다. ()괄호가 들어가면 스태틱
	// Scanner(system.in) 은 생성자 역할은 객체를 만드는 것
	// new는 객체생성자를 만들때 쓰는 명령어?
	while (true) {
//	    System.out.println(sc.nextLine());

		// cmd 지역변수안에 스캐너를 넣음 => 저장해서 재사용 하기위해 입력
		System.out.printf("cmd) ");
		String cmd = sc.nextLine();
		System.out.println("입력된 글 ) "+ cmd);
		
		
		if (cmd.equals("exit")) { // cmd와 exit의 가진값이 같은가? -> 맞음 
		// equals는 boolean값을 가진 메소드다
        //왜 == 논리 연산자는 안될까?
//      if ( cmd == "exit") { // cmd와 "exit의 주소값이 같은가? -> 아니다

			break;
			// if문을 써서 break를 넣고 equals를 써서 논리를 입력함.	
		}

	}
	System.out.println("== 프로그램 종료 ==");
	// 그냥 반복하는 while문에서 while문이 종료될 수 없기에 오류가 뜬다.
sc.close();
// 종료를 안하면 sc는 메모리 쓰레기가 됨
// 이런 쓰레기메모리를 정리하는것이 있는데 G.C(garbage collector)를 사용하면 되므로 꼭 안해도 되는 명령이다
}

}
