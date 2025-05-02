package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) {
		String serverIP = "127.0.0.1";  //접속할 서버주소( 127.0.0.1은 localhost = 내컴퓨터)
		int port = 9999; // 서버와 통신할 포트주소, 서버와 동일해야한다.
		// 서버의 ip 주소와 포트를 선언
		
		try (Socket socket = new Socket(serverIP,port)) {
			// 소켓을 객체를 생성하여 서버와의 연결 시도.
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			// 서버에 문자를 보내기 위한 출력 스트림
			out.println("안녕하세요");
			// 서버에 보내는 문자열
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//getInputStream()-> 서버가 보낸 바이트 데이터를 가져옴
			//InputStreamReader() 가져온 바이트 언어를 스트림으로 변환
			// BufferedReader() = 문자스트림은 버퍼링해서 읽을수 있도록 도와주는 클래스 .readLine메서드를 사용
			
			String serverResponse = in.readLine();
			//서버가 보내온 응답 읽기 readLine() 메서드로 가져오기
			
			System.out.println("서버응답 : " + serverResponse);
			// 서버응답 출력
         } catch (IOException e) {
        	 // 방화벽이든 예상치못한 예외상황 발생시
             e.printStackTrace();
             // 로그를 처리해라
         }
     }
 }