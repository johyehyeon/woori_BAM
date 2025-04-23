import java.util.Scanner;

public class Arr2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, max;
		int[] arr = new int[10];
		System.out.println("정수 10개를 입력하라.");
		for ( i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
 		}
		
		// max에 배열 첫 값으로 초기화
		max = arr[0]; // max에 배열 첫 값을 넣는다.
		
		// 입력받은 1-개의 숫자 중 가장 큰 값을 구한다.
		for (i = 0 ; i < arr.length ; i++) {  // i가 10보다 작을때까지 i 는 1씩 더함.
			if (max < arr[i]) { // max가 arr[i] 보다 작으면
				max = arr[i];   // max에 arr[i] 값을 넣는다
			}
		}
		System.out.println("max = " + max );
	}
}
