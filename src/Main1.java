
import java.util.List;

class Main {
	public static void main1(String[] args) {
        // 객체 생성시 id 증가 시킴.   확인후 주석 처리
//		System.out.println(new Article().id); 
//		System.out.println(new Article().id);
		
		// 배열의 문제점 크기 10인데, 객체를 부족하게 만들면 
		// NullPointerException 발생함
//		Article[] articles = new Article[10];
//		articles[0] = new Article();
//		articles[1] = new Article();
//		articles[2] = new Article();
//		articles[3] = new Article();
//		articles[4] = new Article();
//		articles[5] = new Article();
//		articles[6] = new Article();     
//
//		for (Article article : articles) {
//			System.out.println(article.id);  // 향상된 for문에서 인덱스 7,8,9 예외발생함
//		}
	
		exam01();
	}

	// 생각 : 인덱스 6번까지 생성하고 6번까지만 출력하려면 어떻게 하나요?
	// 결론 : 할 수는 있다. 하지만 불편하고 max 값이 존재하는 한계가 있음

	
	static void exam04() { //List의 타입은 인터페이스 ArrayList는 클레스
		List<Article> articles = new List(); // ctrl + shift + O, c, s 
		articles.add(new Article()); 

	}
	static void exam01() { // 배열의 한계

		int articleLength = 0;
		Article[] articles = new Article[10];

		articles[0] = new Article();
		articleLength++;
		articles[1] = new Article();
		articleLength++;
		articles[2] = new Article();
		articleLength++;
		articles[3] = new Article();
		articleLength++;
		articles[4] = new Article();
		articleLength++;
		articles[5] = new Article();
		articleLength++;


		for (int i = 0; i < articleLength; i++) {
			Article article = articles[i];
			System.out.println(article.id);
		}
	}

}

class Article {
	static int lastId;
	int id;

	static {
		lastId = 0;
	}

	Article() {
		this(lastId + 1);
		lastId++;
	}

	Article(int id) {
		this.id = id;
	}
}