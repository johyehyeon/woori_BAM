package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int listArticleId = 1;
		List<Article> articles = new ArrayList<Article>();
		int viewCount = 0;
	
		
		for (int i = 1 ; i<=3 ; i++ ) {
			Article article = new Article(listArticleId ,"제목"+ i ,"내용" + i , Util.getDateStr(), i*10);
			articles.add(article);
			listArticleId = listArticleId + 1 ;
		}
		
		while (true) {

			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
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
					System.out.printf("%d  | %s  : %s  (%s) | %d \n", article.id, article.title, article.body,
							article.day, article.viewCount); // 출력
				}

			} else if (cmd.startsWith("article detail")) { // 입력값이 ""로 시작하면

				// split(",") ,로 문자열을 쪼개는 메소드
				String[] cmdBits = cmd.split(" "); // cmd의 문자열을 공백을 기준으로 쪼갠다.(복수의 문자열로 나온다)

				Article foundAticle = null; // 방법2 객체
				int id = 0;

				try { // 예외처리 : 오류가 발생하면 비정상 종료가 안되게끔
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) { //

				}
				for (Article A : articles) { // articles 안에 있는 모든정보가 i으로 넘겨받는다
					if (A.id == id) {

						foundAticle = A;
						break;
					}

				}
				if (foundAticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				foundAticle.viewCount++;
				// 객체에 +1 넣어줌

				System.out.println("번호 : " + foundAticle.id);
				System.out.println("날짜 : " + foundAticle.day);
				System.out.println("제목 : " + foundAticle.title);
				System.out.println("내용 : " + foundAticle.body);
				System.out.println("조회수 : " + foundAticle.viewCount);

			} else if (cmd.startsWith("article delete")) {
				String[] cmdBits = cmd.split(" ");

				Article foundAticle2 = null;

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
					if (A.id == id2) {
						foundAticle2 = A;
						foundIndex = indexId;
						break;
					}
					indexId++; // 향상된for문 인덱스찾기
				}

				if (foundAticle2 == null) {
					System.out.println(id2 + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				articles.remove(foundIndex);

				System.out.println(foundAticle2.id + "번 게시글이 삭제되었습니다.");

			} else if (cmd.startsWith("article modify")) {
				String[] cmdBits = cmd.split(" ");
				Article foundAticle3 = null;

				int id3 = 0;

				try {
					id3 = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) {

				}

				for (Article A : articles) {
					if (A.id == id3) {
						foundAticle3 = A;
						break;
					}
				}

				if (foundAticle3 == null) {
					System.out.println(id3 + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine().trim();
				String day = Util.getDateStr();

				foundAticle3.title = title;
				foundAticle3.body = body;
				foundAticle3.day = day;
				// 객체에 대한 주소값을 다시 넣어주는 과정..

				System.out.println(foundAticle3.id + "번 게시글이 수정되었습니다.");

			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
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
	String day;
	int viewCount;

	public Article(int id, String title, String body, String day, int viewCount) {
		// 생성자를 이용해서 초기화하여 변수넣기
		this.id = id;
		this.title = title;
		this.body = body;
		this.day = day;
		this.viewCount = viewCount;
	}

	public void add(int i, String string, String string2, String dateStr, int j) {
		// TODO Auto-generated method stub
		
	}
}
