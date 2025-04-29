package com.woori.BAM.dto;
//dto는 private을 사용한다. getter, setter 생성
public class Article {
	private int id;
	private String title;
	private String body;
	private String day;
	private int viewCount;
	// private선언된 변수에 get set으로 해서 주고받고를 하게 해줘야 한다.
	// dto는 db와 연관되어 있는 것이기 때문에 private으로 해줘야 데이터에대한 보안이 이루어진다

	public Article(int id, String title, String body, String day, int viewCount) {
		// 생성자를 이용해서 초기화하여 변수넣기
		this.setId(id);
		this.setTitle(title);
		this.setBody(body);
		this.setDay(day);
		this.setViewCount(viewCount);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

}