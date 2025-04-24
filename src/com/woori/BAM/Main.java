package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int id = 1; 
		List<Article> articles = new ArrayList<Article>();

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

				Article article = new Article(id, title, body);
				articles.add(article);


				System.out.printf(id + "글이 생성되었습니다.\n");
				id++;

			} else if (cmd.equals("article List")) { // List 출력할때

				if (articles.size() == 0) {

					System.out.println("게시글이 없습니다.");
					continue; // while문 처음으로 돌아감.
				}

				System.out.println("번호 | 제목");

				for (int i = articles.size() - 1; i >= 0; i--) { // 역순으로 출력하기
					Article article = articles.get(i); // get으로 가져와서
					System.out.printf("%d    | %s \n", article.id, article.title); // 출력
				}
			} else if(cmd.startsWith("article detail")){ //입력값이 ""로 시작하면
				// startsWith() / 문자가 시작하는 것을 확인해서 비교 참or거짓
				// article detail 시작하니?
				System.out.println("1번 게시물이 존재하지 않습니다.");
				
				//split(",") ,로 문자열을 쪼개는 메소드
				String[] cmdBits =cmd.split(" "); // cmd의 문자열을 공백을 기준으로 쪼갠다.(복수의 문자열로 나온다)
				//쪼개지면 배열이 되기때문에 배열 String[]이 되어야한다.
				System.out.println(cmdBits[0]);
				System.out.println(cmdBits[1]);
				System.out.println(cmdBits[2]);
				
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
