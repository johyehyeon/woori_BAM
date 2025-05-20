package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpUpdate {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String password = "tiger";

        String sql = "UPDATE emp SET sal = sal * 0.9 WHERE deptno = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            
            conn.setAutoCommit(false);
            // 자동커밋을 falsd로 설정(선택적이지만 명확하다?)
            

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 20); // 부서번호 20번 사원들 급여 인상

            int result = pstmt.executeUpdate();
            System.out.println(result + "건의 급여가 하향?되었습니다.");
            
            conn.commit(); // 변경사항 저장
            System.out.println("커밋완료되었습니다.");


            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}