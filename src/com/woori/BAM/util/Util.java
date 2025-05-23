package com.woori.BAM.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
// 시간을 가져오는 유틸
	// public 이 있어야 메인 클레스에서 import 할 수 있다.
		
		public static String getDateStr() {
		//  LocalDate now = LocalDate.now(); //날짜구하는 방법
		LocalDateTime nowtime = LocalDateTime.now(); //날짜와 시간을 구하는 방법
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		// 시간 hh로 하면 12시간별로, HH로 하면 24시간 기준으로 나온다.
		// 날짜와 시간의 형식을 정하는 방법
		String formatedNow = nowtime.format(formatter);
		// 지금의 날짜와 시간의 형식을 정해진대로 넣고 formatedNow에 넣는다
		return formatedNow;
		}

}
