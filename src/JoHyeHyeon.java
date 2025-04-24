import java.util.Scanner;

public class JoHyeHyeon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력받은 학생 수 :");
		int count = sc.nextInt(); // 학생수를 입력받기

		String[] names = new String[count]; // 학생의 이름을 입력받는 배열
		int[] scores = new int[count]; //
		String[] grade = new String[count];
		int sum = 0;

		for (int i = 0; i < count; i++) {
			System.out.print("학생의 이름 : "); 
			String name = sc.next();// 학생의 이름을 입력받기
			System.out.print("학생의 점수 : ");
			int score = sc.nextInt();//학생의 점수를 입력받기

			names[i] = name;
			scores[i] = score;
			sum = score + sum;  // 합계구하기.. 필요없음..
		}

		for (int i = 0; i < count; i++) {  
			
			int num = scores[i] ; 

			switch (num / 10) {
			case 10:
			case 9:
				grade[i] = "A";
				break;
			case 8:
				grade[i] = "B";
				break;
			default:
				grade[i] = "c";
				break;

			}
			System.out.println("학생이름 : "+ names[i] + "\n점수 : " + scores[i] + "\n등급: "  + grade[i]); // 출력
		}

	}
}