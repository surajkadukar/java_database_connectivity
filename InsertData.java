import java.sql.*;
import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/employee";

            // String databaseName = "Employee";
            String userName = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection Established");

            Scanner sc = new Scanner(System.in);

            System.out.println("======= Enter Employee Details ======");
            System.out.print("Enter Id: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter Job Title: ");
            String job_title = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String sql = "INSERT INTO emp(id, name, job_title, salary) " +
                    "VALUES (" + id + ", '" + name + "', '" + job_title + "', " + salary + ")";
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Insert record Successfull " + rowsAffected + " rows(S) rffected");
            } else {
                System.out.println("Insertion failed!");
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