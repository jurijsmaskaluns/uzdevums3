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
             PreparedStatement ps = c.prepareStatement("SELECT id,name from product");
             ResultSet resultSet = ps.executeQuery();) {

            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                products.add(new Product(id, name));
            }
            return products;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getProducts());
    }

//    public static void deleteProduct(int id) {
//        Product d = null;
//        for (Product p : products) {
//            if (p.id == id) {
//                d = p;
//            }
//        }
//        if (d != null) {
//            products.remove(d);
//        }
//    }

    public static void addProduct(String name) throws SQLException, ClassNotFoundException {
//        products.add(new Product(products.size(), name));
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO product (name) VALUES (?)");) {
            ps.setString(1, name);
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
