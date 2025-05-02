  package networkTest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleServer {

	public static void main(String[] args) {
		int port = 9999;
		
		try (ServerSocket serverSocket = new ServerSocket(port)) { 
			System.out.println("서버가 포트 " +  port + "에서 서버가 준비되었습니다. 클라이언트를 기다리는중...");
			
			Socket clientSocket = serverSocket.accept(); 
			// 클라이언트 접속을 대기하다가 접속요청이 오면 객체를 반환한다.
			System.out.println("클라이언트 연결됨" + clientSocket.getInetAddress());
			// 클라이언트 IP주소를 가져옴
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//getInputStream()-> 클라이언트가 보낸 바이트 데이터를 가져옴
			//InputStreamReader() 가져온 바이트 언어를 스트림으로 변환
			// BufferedReader() = 문자스트림은 버퍼링해서 읽을수 있도록 도와주는 클래스 .readLine메서드를 사용
			String clientMessage = in.readLine();
			// readLine() 한줄단위로 읽는 메서드 clientMessage 변수에 메세지 담기
			System.out.println("클라이언트로부터 수신 '" + clientMessage + "'");
			// 클라이언트로부터 받은 메세지 출력
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			// 클라이언트에게 문자를 보내기위한 출력 스트림.
			out.println("접속감사합니다.");
			// 클라이언트에 보내는 메세지 입력
			
			clientSocket.close();
			System.out.println("서버종료");
             System.out.println("서버 종료");
             
         } catch (UnknownHostException e) {
        	 // 서버가 꺼져있거나, 서버가 거부를 했거나 등등..
        	 e.printStackTrace();
        	 
         }catch (IOException e) {
        	 // 방화벽이든 예상치못한 예외상황 발생시
             e.printStackTrace();
             // 로그를 처리해라  
         }
     }
 }