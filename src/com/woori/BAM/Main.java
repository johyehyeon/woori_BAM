package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int i = 1; //while 문 안에 있으면 계속 1로 초기화 되기 때문에 2번이 안나온다. 그래서 while문 밖에 넣어놔야한다.

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
				System.out.printf(i + "글이 생성되었습니다.\n");
				i++;
//,ㅡ,ㅡ
			} else {
				System.out.println("존재하지않는 명령어입니다.");
			}
		}
		System.out.println("== 프로그램 종료 ==");
		sc.close();

	}
}
