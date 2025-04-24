import java.util.Scanner;

public class Aaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수를 입력하세요: ");
        int count = sc.nextInt();

        int[] scores = new int[count];
        int sum = 0;

        // 점수 입력 + 유효성 검사
        for (int i = 0; i < count; i++) {
            System.out.printf("%d번 학생 점수: ", i + 1);
            int score = sc.nextInt();
            scores[i] = score;
            sum += score;
        }

        double avg = (double) sum / count;
        int avgDiv = (int) avg / 10;

        char grade;

        switch (avgDiv) {
            case 10: // 100점
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("\n총점: " + sum);
        System.out.printf("평균: %.2f\n", avg);
        System.out.println("등급: " + grade);

        sc.close();
    }
}