package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpInsert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String password = "tiger";

        String sql = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) " +
                     "VALUES (?, ?, ?, ?, SYSDATE, ?, ?, ?)";
        // values 부분 ?표는 나중에 컨버팅 하는 부분
        // sysdate = > 현재 날짜와 시간

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            
            conn.setAutoCommit(false);
            // 자동커밋을 falsd로 설정(선택적이지만 명확하다?)
            
            // SQL문을 미리 준비하고, 파라미터만 바인딩하여 실행하는 객체
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set 저장
            pstmt.setInt(1, 9001);               // empno
            pstmt.setString(2, "JUNHO");         // ename
            pstmt.setString(3, "ANALYST");       // job
            pstmt.setInt(4, 7566);               // mgr
            pstmt.setDouble(5, 3200.0);          // sal
            pstmt.setDouble(6, 0.0);             // comm
            pstmt.setInt(7, 20);                 // deptno

            int result = pstmt.executeUpdate();
            System.out.println(result + "건이 입력되었습니다.");

            conn.commit(); // 변경사항 저장
            System.out.println("커밋완료되었습니다.");

            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
