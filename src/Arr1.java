
import java.util.Scanner;

public class Arr1 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int[] intArr = new int[] {1,2,3,4,5}; // 배열을 생성하고 초기값을 할당
	    // int[] intArr = {1,2,3,4,5} 로 입력해도 같은 값 이다.
	    System.out.printf("intArr[0]: %d", intArr[0]);
	    System.out.printf("  intArr[1]: %d", intArr[1]);
	    System.out.printf("  intArr[2]: %d", intArr[2]);
	    System.out.printf("  intArr[3]: %d", intArr[3]);
	    System.out.printf("  intArr[4]: %d\n", intArr[4]);
	    
	    // 초기화 된 값 출력
	    int i;
	    System.out.println("초기화 된 값 출력");
	    for (i = 0 ; i < intArr.length ; i++){ // length 속성은 배열의 길이를 나타낸다. 배열의 길이는 5
	    	// .은 멤버 접근 연산자/ length는 필드에 속함 . 찍었을때 다르게 나오는 이유는 다른것은들 메소드고 length는 필드여서 다르게 나옴
	    	// 큰 수가 있어도 length를 쓰면 문제없이 값을 설정 할 수 있음..
	    	System.out.print(intArr[i] + "\t");
	    }
	    System.out.println();
	    
	    // 사용자 입력받아 배열에 저장
	    System.out.println("숫자 5개를 입력하시오");
	    for (i = 0 ; i < intArr.length ; i++) { 
	    	intArr[i] = sc.nextInt();
	    }
	    sc.close();
	    
	    // 배열에 저장된 값 출력
	    System.out.println("배열에 저장된 값 출력");
	    for (i = 0; i <intArr.length ; i++) {
	    	System.out.println(intArr[i] + "\t");
	    }
	    
	} 
	
	
}
