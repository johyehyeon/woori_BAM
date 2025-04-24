package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int id = 1; //while 문 안에 있으면 계속 1로 초기화 되기 때문에 2번이 안나온다. 그래서 while문 밖에 넣어놔야한다.
		List<Article> articles = new ArrayList<Article>(); 
		//컬렉션프레임워크인 List 중에 ArrayList를 사용한다.
		//ArrayList는 자동으로 순서를 가진다.
		//List는 Article 타입에 지정된 타입의 객체만을 저장한다.
		//articles는<Article> class 타입이라고 선언만 함


		while (true) {
			
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim(); // trim() 추가
//			System.out.println("cmd = " + cmd);
			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue; // 다시 while문 처음으로 돌아가게함.
			} // 하지만 공백이 있으면 존재하지않는 명령어입니다가 출력됨 -> 공백을 없애야한다. -> cmd에 trim()추가하기

			if (cmd.equals("article List")) {
				System.out.println("게시글이 없습니다.");
			} else if (cmd.equals("article write")) {
				
				System.out.printf("제목 ");
				String title = sc.nextLine();
				System.out.printf("내용 ");
				String body = sc.nextLine();
				
				Article article = new Article(id,title,body);
				//최적화 1
				// 생성자를 이용해서 초기화
				//인자를 통해 생성자를 호출
				
				
//				Article article = new Article();				
//				article.id = id;
//				article.title = title;
//				article.body = body;
//				// article은 지역변수이므로 저장된것은 아니다
//				// 일반 main에 선언했던 내용들을 atricle class로 데이터를 넣어줌
				
				// 위에서 만든 articles에 넣어줘야한다.
				articles.add(article); 
				//List구조인 ArrayList 객체인 articles에 저장(add)함 
				
				// 최적화 2
//				articles.add(new Article(id,title,body)); //최적화1과 add까지 합쳐서 최적화함.
				
								
				System.out.printf(id + "글이 생성되었습니다.\n");
				id++;
				
//			} else if (cmd.equals("test")){ // 글이 제대로 저장됐는지 테스트하는 if줄..
//				for (int i = 0 ; i < articles.size() ; i++) {
//					System.out.println(articles.get(i).id);
//					System.out.println(articles.get(i).title);
//					System.out.println(articles.get(i).body);
//				}

			} else {
				System.out.println("존재하지않는 명령어입니다.");
			}
		}
		System.out.println("== 프로그램 종료 ==");
		sc.close();

	}
}
class Article{
	int id;
	String title;
	String body;
	public Article(int id, String title, String body) {
		// 생성자를 이용해서 초기화하여 변수넣기
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
}
////클래스에 변수선언하면 전역변수
//	public static void main(String[] args) {
////메소드 안에 변수선언하면 지역변수
//		System.out.println("== 프로그램 시작 ==");
//		Scanner sc = new Scanner(System.in); 
//		// System 이란 클래스에 만들어진 in 소스를 가져다 씀
//		// in는 필드이다. .을 누르면 system 안에 필드와 메소드들이 나옴
//		// System.in 아규먼트로 불러오는 스태틱이다. ()괄호가 들어가면 스태틱
//		// Scanner(system.in) 은 생성자 역할은 객체를 만드는 것
//		// new는 객체생성자를 만들때 쓰는 명령어?
//		while (true) {
////		    System.out.println(sc.nextLine());
//
//			// cmd 지역변수안에 스캐너를 넣음 => 저장해서 재사용 하기위해 입력
//			System.out.printf("cmd) ");
//			String cmd = sc.nextLine();
//			System.out.println("입력된 글 ) "+ cmd);
//			
//			
//			if (cmd.equals("exit")) { // cmd와 exit의 가진값이 같은가? -> 맞음 
//			// equals는 boolean값을 가진 메소드다
//            //왜 == 논리 연산자는 안될까?
////          if ( cmd == "exit") { // cmd와 "exit의 주소값이 같은가? -> 아니다
//
//				break;
//				// if문을 써서 break를 넣고 equals를 써서 논리를 입력함.	
//			}
//
//		}
//		System.out.println("== 프로그램 종료 ==");
//		// 그냥 반복하는 while문에서 while문이 종료될 수 없기에 오류가 뜬다.
//	sc.close();
//	// 종료를 안하면 sc는 메모리 쓰레기가 됨
//	// 이런 쓰레기메모리를 정리하는것이 있는데 G.C(garbage collector)를 사용하면 되므로 꼭 안해도 되는 명령이다
//	}
//    

