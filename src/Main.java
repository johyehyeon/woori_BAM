
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
   	Scanner sc = new Scanner(System.in); //스캔 입력 

   	System.out.print("A반의 학생수 입력 : ");
   	int n = sc.nextInt(); // 입력받는 값이 n
   	int[] scores = new int[n]; // n만큼 배열 넣는 배열 scores 선언

   	for (int j = 0; j < scores.length; j++) { // length 로 배열만큼 조건을 정하고 j 선언해서 배열 수 넣어줌
   		System.out.print((j + 1) + "번 학생 점수 입력 : "); //
   		scores[j] = sc.nextInt(); //배열 0번부터 스캔 입력값 넣기
   	}
   	int sum = 0; // 합계 변수 선언
   	double ave = 0.0; // 평균 변수 선언
   	
   	System.out.println("------------------");
   	for (int i = 0 ; i <   scores.length ; i++) {  // i = 0부터 선언하고 length로 배열크기만큼 조건
   		sum += scores[i];  // 합계변수 +=는 배열 0부터 더하기
   	}
   	System.out.println("A반 학생의 총 점수 : " + sum);
   	
   	ave = (double) sum / scores.length; // sum은 int이기 때문에 double로 형변환 해줘야함
   	System.out.printf("A반 학생의 총 평균 : %5.2f " ,ave);
   	sc.close();
   	   		
   	
   }
}