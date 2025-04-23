import java.util.Scanner;

public class Arr3 {

	public static void main(String[] args) {
		int i ;
		float sum = 0, avg;  // 평균을 구할때 실수가 나오니까 실수변수를 선언
		int[] jumsu = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5명의 수학 점수를 입력하시오.");
		for (i=0 ; i < jumsu.length ; i++) {
			jumsu[i] = sc.nextInt();
		}
		
		// 총점 구하기
		for (i=0 ; i < jumsu.length ; i++){
			sum += jumsu[i];	
		}
		System.out.println("총점 : " + sum);
		
		// 평균 구하기
		avg = sum / 5;  // 나누기 할 경우 실수로 나오기 때문에 (float)으로 강제 형변환
		
		System.out.println("평균 : " + avg);
	}
}
