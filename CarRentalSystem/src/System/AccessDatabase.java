package src.System;
import java.sql.*;

public class AccessDatabase {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "fred1234";
    Connection con;
    Statement st;
    ResultSet rs;

    public void ShowVehicle() {
        try {
            String SQLQuery = "SELECT * FROM vehicles";
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery(SQLQuery);

            System.out.println("==== Available Cars ====");
            System.out.println("| ID | Model | Type | Rental Price |");

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                String type = rs.getString("type");
                double price = rs.getDouble("price");

                System.out.println(id + " " + model + " " + type + " " + price);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
