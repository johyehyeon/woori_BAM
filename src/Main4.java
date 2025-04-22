import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		int sum;
		double ave;
		System.out.println("아래에 5명의 영어 점수를 입력하세요");
		Scanner a = new Scanner(System.in);
		double A = a.nextInt();
		Scanner b = new Scanner(System.in);
		double B = b.nextInt();
		Scanner c = new Scanner(System.in);
		double C = c.nextInt();
		Scanner d = new Scanner(System.in);
		double D = d.nextInt();
		Scanner e = new Scanner(System.in);
		double E = e.nextInt();
		
		sum=(int)(A+B+C+D+E);
		ave=((A+B+C+D+E)/5);

		System.out.println("영어총점 : " + sum );
		System.out.println("영어평균 : " + ave );
	}
}
