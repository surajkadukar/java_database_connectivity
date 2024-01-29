import java.sql.*;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/employee";

            // String databaseName = "Employee";
            String userName = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection Established");

            Scanner sc = new Scanner(System.in);

            System.out.println("======= Delete Employee Record ======");
            System.out.print("Enter Id: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM emp where id = " + id + "";
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Record Deleted Successfully " + rowsAffected + " rows(S) rffected");
            } else {
                System.out.println("Deletion failed!");
            }

            statement.close();
            // JOptionPane.showMessageDialog(null, databaseName + " Database has been
            // created successfully",
            // "System Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}