import java.util.Scanner;

public class Arr4 {

	public static void main(String[] args) {
		int i , num ;
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println("검색할 숫자를 입력하시오.");
		num = sc.nextInt();
		for( i = 0 ; i < arr.length ; i++) {
			if (num == arr[i]) { // 입력한 값과 같은 인덱스를 검색
				flag = true;  // 왜지??
				System.out.println("인덱스 "+ i +" 에서 검색");
				break;
			}
		}
		if (!flag) {
			System.out.println("찾는 값이 없다.");
		}
		sc.close();
	}

}
