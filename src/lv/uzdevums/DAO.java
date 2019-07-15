package lv.uzdevums;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/tehnika", "root", "12345");

    }


    public static List<Product> getProducts() throws SQLException, ClassNotFoundException {

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * from product");
             ResultSet resultSet = ps.executeQuery();) {

            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date created = resultSet.getDate(3);
                String productType = resultSet.getString(4);
                int status = resultSet.getInt(5);
                products.add(new Product(id, name, created, productType, status));
            }
            return products;
        }
    }


    public static void addProduct(String name, String productType) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement("INSERT INTO product(name, productType) values(?,?)");
                )
        {
            ps.setString(1,name);
            ps.setString(2,productType);
            ps.executeUpdate();
        }
    }

    public static void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM product WHERE id=?");) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }

    }
}
