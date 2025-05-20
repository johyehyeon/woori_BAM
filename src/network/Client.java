package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		String serverIP = "127.0.0.1";
	    int port = 9999;
	    // 서버대기 port와 접속ip
	    
	    
	    // 3. 서버접속
	    try (Socket socket = new Socket(serverIP,port)){
	    	
	    	// 4. 서버에게 메세지 전달
	    	PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
	    	out.println("안녕하세요 서버! 응답바랍니다.");
	    	// 서버에게 전달
	    	
	    	
	    	// 7. 서버로부터 메세지를 받고, 확인
	    	InputStreamReader isr = new InputStreamReader(socket.getInputStream());
	    	// getinputstream(inputstream 클래스) 메소드를 써서 서버로부터 바이트언어를 가져오고 
	    	// inputstreamreader로 스트림언어로 변환하여 생성
	    	BufferedReader in = new BufferedReader(isr);
	    	// 스트림언어를 불러오기위한 bufferedpeader 생성
	    	String serverRsponse = in.readLine();
	    	// 스트림언어를 한줄씩 불러와러 String으로 저장
	    	System.out.println("서버 응답 : "+ serverRsponse);
	    	// 서버응답 메세지 출력
	    	
			
		} catch(IOException e) {
			e.printStackTrace();
			// 예외상황 발생시 오류를 출력
		}
		
	}

}
