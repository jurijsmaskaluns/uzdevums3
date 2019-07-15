import lv.uzdevums.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProductServlet", urlPatterns = "/delete")// "Servlet" pieslēgšana saitei
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            DAO.deleteProduct(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/products");
    }// Pēc šis saites: <a href="delete?id=${product.id}">delete</a> tiek nodotas ID vērtības, kura tālāk tiek nodota "deleteProduct" metodei, kura atrodas DAO klasē
}   // Citiem vārdiet tiek veikta datu apstrāde, datu dzēšanai pēc produkta ID

