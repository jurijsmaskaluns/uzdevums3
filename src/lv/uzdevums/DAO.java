package lv.uzdevums;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/tehnika", "root", "12345");
    }//standarta pieslēgšanos pie datu bāzes, draiveru uzstadīšana

    public static List<Product> getProducts() throws SQLException, ClassNotFoundException { //visu produktu saraksta veidošana no datu bāzes
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * from product");
             ResultSet resultSet = ps.executeQuery();) //savienošanos ar datu bāzi, pieprasījuma veidošana datu bāzei, šajā gadījumā visu ieraksti izvēle
        {

            ArrayList<Product> products = new ArrayList<>(); //tiek izveidojs jauns datu masīvs
            while (resultSet.next()) { // "while" cikls iziet visus datu bāzes ierakstus
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date created = resultSet.getDate(3);
                String productType = resultSet.getString(4);
                String status = resultSet.getString(5);
                products.add(new Product(id, name, created, productType, status)); // veido objektus
            }
            return products;
        }
    }

    public static void addProduct(String name, String productType) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO product(name, productType) values(?,?)");
        ) {
            ps.setString(1, name);
            ps.setString(2, productType);
            ps.executeUpdate();
        }
    }//metode, kura aizpilda datu bāzi ar ievadītiem parametriem

    public static void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM product WHERE id=?");) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }//datu dzēšano no datu bāzes

    public static void confirmProduct(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE product SET status = 'CONFIRMED' WHERE id=?");) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }//datu bāzes ieraksta atjaunošana
    public static void rejectProduct(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE product SET status = 'REJECTED' WHERE id=?");) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }//datu bāzes ieraksta atjaunošana
}

