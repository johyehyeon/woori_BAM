package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void main(String[] args) {
		int port = 9999;
		// 서버 대기 port
	    
		// 1. 서버 연결 대기중
	    try (ServerSocket serverSocket = new ServerSocket(port)) {
	    	System.out.println("서버 대기중... 클라이언트 접속을 기다리고 있습니다.");
	    	//서버가 열리고 대기중.. 대기중 메세지 출력
	    	
	    	//2. 클라이언트가 접속시
	    	Socket clientSocket = serverSocket.accept();
	    	System.out.println("클라이언트와 연결 완료 " + clientSocket.getInetAddress());
	    	// 클라이언트가 접속했을때 메세지 출력
	    	
	    	// 5. 클라이언트로부터 메세지를 받고, 확인
	    	InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
	    	// getinputstream(inputstream 클래스) 메소드를 써서 클라이언트로부터 바이트언어를 가져오고 
	    	// inputstreamreader로 스트림언어로 변환하여 생성
	    	BufferedReader in = new BufferedReader(isr);
	    	// 스트림언어를 불러오기위한 bufferedpeader 생성
	    	String clientMessage = in.readLine();
	    	// 스트림언어를 한줄씩 불러와러 String으로 저장
	    	System.out.println("클라이언트 요청 : "+ clientMessage);
	    	// 클라이언트 요청 출력
	    	
	    	// 6. 클라이언트에게 응답 전달
	    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
	    	out.println("안녕하세요 클라이언트! 응답드립니다.");
	    	// 클라이언트에게 전달
	    	
	    	// 8. 클라이언트와 연결 종료
	    	clientSocket.close();
	    	System.out.println("서버연결 종료");
	    		    	
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			// 호스트를 찾지 못했을때 오류를 출력
		} catch(IOException e) {
			e.printStackTrace();
			// 기타 다른 예외상황 발생시 오류를 출력
		}
		
		
	}

}
