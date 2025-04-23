import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 학생 수 입력
        System.err.print("학생수를 입력하세요 : ");
        int student = sc.nextInt();
        int[] A = new int[student];
        int sum = 0;
        double ave = 0.0;
        System.out.println("총학생수 : " + student);
        
        for (int i ; i < )
        
       
    }
}
//import java.util.Scanner;
//
//public class GradeCalculatorSwitch {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 학생 수 입력
//        System.out.print("학생 수를 입력하세요: ");
//        int studentCount = scanner.nextInt();
//
//        int[] scores = new int[studentCount];
//        int sum = 0;        
        
        // 점수 입력
//        for (int i = 0; i < studentCount; i++) {
//            System.out.print((i + 1) + "번 학생의 점수를 입력하세요: ");
//            scores[i] = sc.nextInt();
//            sum += scores[i];
//        }

//        // 평균 계산
//        double average = (double) sum / studentCount;
//
//        // 평균의 10의 자리로 등급 분기
//        int avgScore = (int) average / 10;
//
//        char grade;
//
//        // switch문으로 등급 계산
//        switch (avgScore) {
//            case 10: // 100점
//            case 9:
//                grade = 'A';
//                break;
//            case 8:
//                grade = 'B';
//                break;
//            case 7:
//                grade = 'C';
//                break;
//            case 6:
//                grade = 'D';
//                break;
//            default:
//                grade = 'F';
//        }
//
//        // 결과 출력
//        System.out.println("\n총점: " + sum);
//        System.out.printf("평균: %.2f\n", average);
//        System.out.println("등급: " + grade);
//
//        scanner.close();
//    }
//}
