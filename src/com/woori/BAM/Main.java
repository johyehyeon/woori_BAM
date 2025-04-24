package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int id = 1; // while 문 안에 있으면 계속 1로 초기화 되기 때문에 2번이 안나온다. 그래서 while문 밖에 넣어놔야한다.
		List<Article> articles = new ArrayList<Article>();
		// 컬렉션프레임워크인 List를 상속받는 ArrayList를 사용한다.
		// ArrayList는 자동으로 순서를 가진다.
		// List는 Article 타입에 지정된 타입의 객체만을 저장한다.
		// articles는<Article> class 타입이라고 선언만 함

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

			if (cmd.equals("article write")) {

				System.out.printf("제목 ");
				String title = sc.nextLine();
				System.out.printf("내용 ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				// 최적화 1
				// 생성자를 이용해서 초기화
				// 인자를 통해 생성자를 호출

//				Article article = new Article();				
//				article.id = id;
//				article.title = title;
//				article.body = body;
//				// article은 지역변수이므로 저장된것은 아니다
//				// 일반 main에 선언했던 내용들을 atricle class로 데이터를 넣어줌

				// 위에서 만든 articles에 넣어줘야한다.
				articles.add(article);
				// List구조인 ArrayList 객체인 articles에 저장(add)함

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

			} else if (cmd.equals("article List")) { // List 출력할때

				if (articles.size() == 0) {
					// size()는 arr가 얼마인지 계산해서 리턴하는 List의 주요 메소드
					// 뜻 : articles(객체)의 사이즈가 0일때

					System.out.println("게시글이 없습니다.");
					continue; // while문 처음으로 돌아감.
				}

//if문시작		if (articles.size() != 0) { // articles가 0과 다를 때
// if문이 두번일 필요가 있을까? 아니요, article List가 호출될때 기본적으로 적용되고
// 0일경우만 if를 적용하도록 하면 됨.
				System.out.println("번호 | 제목");
//정방향 출력		for (int i = 0; i < articles.size(); i++) {
				    
				    for (int i = articles.size()- 1 ; i>=0 ; i-- ) { //역순으로 출력하기
					Article article = articles.get(i); // get으로 가져와서
					System.out.printf("%d    | %s \n", article.id, article.title); // 출력

					// 또다른 방법, get과 출력을 같이
					// System.out.printf("%d | %s \n", articles.get(i).id, articles.get(i).title);
				}
//if문끝나기    }
			} else {
				System.out.println("존재하지않는 명령어입니다.");
			}
		}
		System.out.println("== 프로그램 종료 ==");
		sc.close();

	}
}

class Article {
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
