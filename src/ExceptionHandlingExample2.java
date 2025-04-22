
public class ExceptionHandlingExample2 {

	public static void printLength(String data) { // main 메소드에서 실행된 값이 들어감
        // 예외처리문
 		try { // 예외가 발행할지 않을지 모르는 코드블록 정의
		    int result = data.length();
		    System.out.println("문자수 : " + result + "\n");    
        // 블록 내부에서 예외가 발생할 경우 호출되는 문장블록
 		} catch(NullPointerException e) {
 			System.out.println("[값이 null값입니다 아래 문장을 확인하세요.]\n");
 			System.out.println(e.getMessage());  
 			//발생한 예외 클래스의 인스턴스에 저장된 메세지를 얻을 수 있음.(간단한 정보)
 			System.out.println(e.toString());
			// getMessage + 어떤 Exception이 발생했는지 보여줌
            e.printStackTrace();
 			// getMessage + 어떤 Exception이 발생했는지 에러가 발생한 위치까지 보여줌
		// try 블록에서 일어난 일에 관계없이 항상 실행해야한 뒷정리용 코드
 		} finally {
			System.out.println("[마무리실행]\n"); 
		}
	}

    // 1. 메인메소드가 먼저 실행됨
    public static void main(String[] args) {
        System.out.println("[프로그램시작]\n");
        // 2. PrintLength에 thisishava를 넣어서 실행
        printLength("ThisIsJava");
        // 3. printLength 에 null값을 넣어서 실행
    	printLength(null);
    	//
    	System.out.println("[프로그램종료]");;
    	
 }

}
