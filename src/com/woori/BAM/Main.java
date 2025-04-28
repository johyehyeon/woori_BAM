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
//		//  LocalDate now = LocalDate.now(); //날짜구하는 방법
//			LocalDateTime nowtime = LocalDateTime.now(); //날짜와 시간을 구하는 방법
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
//			// 시간 hh로 하면 12시간별로, HH로 하면 24시간 기준으로 나온다.
//			// 날짜와 시간의 형식을 정하는 방법
//			String formatedNow = nowtime.format(formatter);
//			// 지금의 날짜와 시간의 형식을 정해진대로 넣고 formatedNow에 넣는다
// 전부 Util 클레스로 넣어서 주석처리
			
			
			
			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
			    System.out.println("날짜 : " + Util.getDateStr());
			    // 바로 Util.getDateStr() 넣어도 실행된다.. 스태틱메서드
				String day = Util.getDateStr();
				//day에 현재날짜넣기
				
				Article article = new Article(listArticleId, title, body, day);
				articles.add(article);

				System.out.printf(listArticleId + "글이 생성되었습니다.\n");
				listArticleId++;

			} else if (cmd.equals("article List")) { // List 출력할때

				if (articles.size() == 0) {

					System.out.println("게시글이 없습니다.");
					continue; // while문 처음으로 돌아감.
				}

				System.out.println("번호 | 제목 : 내용 (시간)");

				for (int i = articles.size() - 1; i >= 0; i--) { // 역순으로 출력하기
					Article article = articles.get(i); // get으로 가져와서
					System.out.printf("%d    | %s : %s (%s)\n", article.id, article.title, article.body, article.day); // 출력
				}
			} else if (cmd.startsWith("article detail")) { // 입력값이 ""로 시작하면
				// startsWith() / 문자가 시작하는 것을 확인해서 비교 참or거짓
				// article detail 시작하니?

				// split(",") ,로 문자열을 쪼개는 메소드
				String[] cmdBits = cmd.split(" "); // cmd의 문자열을 공백을 기준으로 쪼갠다.(복수의 문자열로 나온다)
				// 쪼개지면 배열이 되기때문에 배열 String[]이 되어야한다.
//				System.out.println(cmdBits[0]); // => article
//				System.out.println(cmdBits[1]); // => detail
//				System.out.println(cmdBits[2]); // => 1
				// 숫자가 cmdBits[2]에 들어가는것을 확인했음
				// 번호가 들어간 게시글들을 확인하기 위해선 articles(type Article)을 순차적으로 확인해서 게시글이 있는지 찾아야한다
				// 향상된 for문을 숙지해야 풀어나갈 수 있다.

// 방법1(변수) 	boolean articleChk = false; 
				Article foundAticle = null; // 방법2 객체
				// 객체로 대치(변수 1개, 객체는 정보를 넣을수잇어서 활용도가 높다)
				// 의미 if(foundAticle == null)
				// 고민을 많이 해야할 영역 try catch문..
				int id = 0;

				try { // 예외처리 : 오류가 발생하면 비정상 종료가 안되게끔
					id = Integer.parseInt(cmdBits[2]);
					// cmdBits는 string 타입이라서 int타입 비교와 맞지않는다. 하여 Integer.parseInt()를 써서 int 타입으로 바꿔줌
					// 별도위치로 재정의하면서 가동성이 올라가고 재활용도가 올라감..
					// 스태틱 메서드 -> 대문자->class 명을 바로 적고 호출을 할 수 있다.. 객체를 안만들고..
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) { //

				}
				for (Article A : articles) { // articles 안에 있는 모든정보가 i으로 넘겨받는다
					// i에 i.title i.id i.body 다 있음
					if (A.id == id) {

						// 방법1 articleChk = true;
						foundAticle = A;
//방법1					System.out.println("번호 : " + A.id );
//방법1					System.out.println("날짜 : yyyy.mm.dd");
//방법1					System.out.println("제목 : " + A.title);
//방법1					System.out.println("내용 : " + A.body);
						break;
					}
					// 출력문을 아래로 내려서 해당for문을 다른곳에도 재활용을 할 수 있게 메소드화 시켜 공통으로 사용할 수 있게 한다.

				}
				// 방법1 if (articleChk == false) {
				if (foundAticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					// 만약 detail 명령어에 글자를 넣게되면 Exception 오류가 발생한다 -> try문으로 예외처리를 해야함
					continue;
					// 아래에서 nullpointexception이 발생이 안되도록 조치
				}
				System.out.println("번호 : " + foundAticle.id);
				System.out.println("날짜 : " + foundAticle.day);
				System.out.println("제목 : " + foundAticle.title);
				System.out.println("내용 : " + foundAticle.body);

			} else if (cmd.startsWith("article delete")) {
				String[] cmdBits = cmd.split(" ");

				Article foundAticle2 = null;

				
				// index삭제로 할경우 
				int id2 = 0;
				try {
					id2 = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("번호에 글자가 입력되어 실행되지 않습니다.");
					continue;
				} catch (Exception e) { 
				}
				
				int foundIndex = -1; //int는 0이 초기값인데 -1 이면 null과 같은 개념 계속 ++하면서
				int indexId = 0; // 단순 인덱스를 계산하는 변수
				
				// 향상된 for문 인덱스 사용 x , 일반 for문 사용	
				for (Article A : articles) {
					if (A.id == id2) {
						foundAticle2 = A;
						foundIndex = indexId;
						break;
					}
					indexId++;	// 향상된for문 인덱스찾기
				}

//일반for문			for (int i = 0; i < articles.size(); i++) {
//					Article article = articles.get(i);
//					if (article.id == id2) {
//						break;
//					}
//				} //일반 for문을 쓰면 인덱스를 찾기 쉬움

				if (foundAticle2 == null) {
					System.out.println(id2 + "번 게시물이 존재하지 않습니다.");
					continue;
				}
//일반 for문    articles.remove(id2);
		//		articles.remove(foundAticle2);
				// remove에서 오브젝트를 삭제함 id2를 삭제했으면 인덱스가 삭제되어 뒤에 자료들이 땡겨져서 오류가 발생할 수 있음
                // 객체에서 삭제하기 때문에 articles로 객체에서 찾아서 삭제한다.
				articles.remove(foundIndex);
				
				System.out.println(foundAticle2.id + "번 게시글이 삭제되었습니다.");
			
				

			} else if(cmd.startsWith("article modify")){
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

	public Article(int id, String title, String body, String day) {
		// 생성자를 이용해서 초기화하여 변수넣기
		this.id = id;
		this.title = title;
		this.body = body;
		this.day = day;
	}



	}
