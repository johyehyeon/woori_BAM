package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woori.BAM.dto.Article;
import com.woori.BAM.util.Util;

public class App {

//	// 테스트 데이터입력2를 위한 전역변수 	
//		// 전역변수 위치에 있어야 static 메서드를 만들수 있고, static 메서드에서 사용할 수 있다..
//		static int listArticleId ;
//		static List<Article> articles;
//		// 전역변수는 선언초기화를 안하면 기본값을 가진다 하여 초기화를 하든말든 선택
//		// 지역변수는 선언하면서 동시에 초기화를 해줘야한다. 기억할것
	int listArticleId;
	List<Article> articles;
	// Main클래스에 있을때는 static main 메서드 밖으로 선언되어 전역변수로 만들었지만 지금 run메소드로 바뀌면서 전부 전역으로 바뀌어서 static변수로 선언 할 이유가
	// 없어짐

	App() {
		articles = new ArrayList<>();
		listArticleId = 1;
	}

	void run() {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

//	static int listArticleId = 1;
//	static List<Article> articles = new ArrayList<Article>();
		// static을 붙인 이유 : 메소드를 만들어서 쓸라면 static을 붙여야 사용될수있다.
		// 하지만 static을 붙여도 각 지열의 로컬에서 쓰이기때문에 오류남 -> 로컬에서 벗어나서 메인에 선언되어야한다..

		int viewCount = 0;

		// 프로그램 시작됐을때 테스트데이터 생성하기
//테스트 데이터 입력2
		makeTestData(); // 스테틱 메서드 만들기 (해당메서드가 만들어지는 위치는 메인메서트 밖)
		// static메서드일수밖에 없는 이유를 설명할 줄 알아야함
		// 스태틱메서드 <> 인스턴스 메서드 차이점 생각해볼것

//테스트 데이터 입력1
		// for (int i = 1 ; i<=3 ; i++ ) { // 순차적으로 반복해서 수가 늘어나기 때문에 for문 사용
//		articles.add(new Article(listArticleId++ ,"제목"+ i ,"내용" + i , Util.getDateStr(), i*10));
////		Article article = new Article(listArticleId ,"제목"+ i ,"내용" + i , Util.getDateStr(), i*10);
////		// 생성자로 해서 내용을 입력하게
////		articles.add(article);
////		listArticleId++ ; // 정보를 배열에 저장 후 +1 -> 윗줄에 추가해서 입력할수있음
//	}

//     Article ar = new Article(listArticleId++,Util.getDateStr(),"제목1","내용1" ,10);
//     articles.add(ar);
		while (true) {

			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			// trim() 앞뒤공백을 없애는 명령어

			if (cmd.equals("exit")) {
				break; // exit를 누르면 while 반복문을 나간다
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}

			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
				System.out.println("날짜 : " + Util.getDateStr());
				// 바로 Util.getDateStr() 넣어도 실행된다.. 스태틱메서드
				String day = Util.getDateStr();
				// day에 현재날짜넣기
				Article article = new Article(listArticleId, title, body, day, viewCount);
				articles.add(article);

				System.out.printf(listArticleId + "글이 생성되었습니다.\n");
				listArticleId++;

			} else if (cmd.equals("article list")) { // List 출력할때

				if (articles.size() == 0) {

					System.out.println("게시글이 없습니다.");
					continue; // while문 처음으로 돌아감.
				}

				System.out.println("번호 |  제목   : 내용       (시간)       | 조회수 ");

				for (int i = articles.size() - 1; i >= 0; i--) { // 역순으로 출력하기
					Article article = articles.get(i); // get으로 가져와서
					System.out.printf("%d  | %s  : %s  (%s) | %d \n", article.getId(), article.getTitle(),
							article.getBody(), article.getDay(), article.getViewCount()); // 출력
				}

			} else if (cmd.startsWith("article detail")) { // 입력값이 ""로 시작하면

				// split(",") ,로 문자열을 쪼개는 메소드
				String[] cmdBits = cmd.split(" "); // cmd의 문자열을 공백을 기준으로 쪼갠다.(복수의 문자열로 나온다)

				Article foundArticle = null; // 방법2 객체
				int id = 0;

				try { // 예외처리 : 오류가 발생하면 비정상 종료가 안되게끔
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) {
				}
				for (Article A : articles) { // articles 안에 있는 모든정보가 i으로 넘겨받는다
					if (A.getId() == id) {

						foundArticle = A;
						break;
					}

				}
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				foundArticle.setViewCount(foundArticle.getViewCount() + 1);
				// 객체에 +1 넣어줌

				System.out.println("번호 : " + foundArticle.getId());
				System.out.println("날짜 : " + foundArticle.getDay());
				System.out.println("제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getBody());
				System.out.println("조회수 : " + foundArticle.getViewCount());

			} else if (cmd.startsWith("article delete")) {
				String[] cmdBits = cmd.split(" ");

				Article foundArticle2 = null;

				int id2 = 0;
				try {
					id2 = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) {
				}

				int foundIndex = -1; // int는 0이 초기값인데 -1 이면 null과 같은 개념 계속 ++하면서
				int indexId = 0; // 단순 인덱스를 계산하는 변수

				// 향상된 for문 인덱스 사용 x , 일반 for문 사용
				for (Article A : articles) {
					if (A.getId() == id2) {
						foundArticle2 = A;
						foundIndex = indexId;
						break;
					}
					indexId++; // 향상된for문 인덱스찾기
				}

				if (foundArticle2 == null) {
					System.out.println(id2 + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				articles.remove(foundIndex);

				System.out.println(foundArticle2.getId() + "번 게시글이 삭제되었습니다.");

			} else if (cmd.startsWith("article modify")) {
				String[] cmdBits = cmd.split(" ");
				Article foundArticle3 = null;

				int id3 = 0;

				try {
					id3 = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) {

				}

				for (Article A : articles) {
					if (A.getId() == id3) {
						foundArticle3 = A;
						break;
					}
				}

				if (foundArticle3 == null) {
					System.out.println(id3 + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine().trim();
				String day = Util.getDateStr();

				foundArticle3.setTitle(title);
				foundArticle3.setBody(body);
				foundArticle3.setDay(day);
				// 객체에 대한 주소값을 다시 넣어주는 과정..

				System.out.println(foundArticle3.getId() + "번 게시글이 수정되었습니다.");

			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}
		System.out.println("== 프로그램 종료 ==");

		sc.close();
	}

	// 테스트 데이터입력2 를 위한 static 메서드
//	private static void makeTestData() { // 메서드 만들기 메인 메서드 맨 끝에 만들어진다.
	void makeTestData() {
		for (int i = 1; i <= 3; i++) { // 순차적으로 반복해서 수가 늘어나기 때문에 for문 사용
			articles.add(new Article(listArticleId++, "제목" + i, "내용" + i, Util.getDateStr(), i * 10));
		}
	}
}
