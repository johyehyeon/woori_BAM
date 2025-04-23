import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 학생 수 입력
        System.out.print("학생 수를 입력하세요: ");
        int studentCount = scanner.nextInt();

        int[] scores = new int[studentCount];
        int sum = 0;

        // 점수 입력
        for (int i = 0; i < studentCount; i++) {
            System.out.print((i + 1) + "번 학생의 점수를 입력하세요: ");
            scores[i] = scanner.nextInt();
            sum += scores[i];
        }

        // 평균 계산
        double average = (double) sum / studentCount;

        // 등급 계산
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // 결과 출력
        System.out.println("\n총점: " + sum);
        System.out.printf("평균: %.2f\n", average);
        System.out.println("등급: " + grade);

        scanner.close();
    }
}