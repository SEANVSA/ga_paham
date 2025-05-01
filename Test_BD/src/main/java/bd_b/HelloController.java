package bd_b;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.*;

public class HelloController extends HelloApplication {

    int num;
    @FXML
    public Button down, up;
    @FXML
    private Label textData, Title;
    boolean first = true;

    @FXML
    protected void up() throws SQLException {
        if (first){
            first = false;
            num = 100;
        }
        else {
            if (num<206) num++;
        }
        write(num);
    }
    @FXML
    protected void down() throws SQLException {
        if (first){
            first = false;
            num = 100;
        }
        else {
            if (num>100) num--;
        }
        write(num);
    }
    protected void write(int num) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT employee_id, first_name || ' ' || last_name AS \"full_name\", salary, coalesce(commission_pct,0), salary +salary*coalesce(commission_pct,0) AS \"total_salary\" FROM employees WHERE employee_id = " + num;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Title.setText(String.valueOf(rs.getInt(1)));
            textData.setText("Name : " + rs.getString(2) + "\nSalary : " + rs.getInt(3)+ "\nCommission (%) : " + rs.getDouble(4)*100+"%"+ "\nCommission : " + rs.getDouble(4) + "\nTotal Salary : " + rs.getInt(5));
        }
    }
}