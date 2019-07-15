import lv.uzdevums.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", urlPatterns = "/add")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); // tiek iegūta mainīgā "name" no pieprasījuma parametriem
        String productType = request.getParameter("type"); // tiek iegūta mainīgā "productType" no pieprasījuma parametriem
        try {
            DAO.addProduct(name,productType); // divu parametru nodošama addProduct metodei, kuras atrodas DAO klasē
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}// Funkcija jaunā produkta pievienošanai datu bāzē