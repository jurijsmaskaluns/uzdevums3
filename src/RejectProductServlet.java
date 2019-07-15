import lv.uzdevums.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RejectProductServlet", urlPatterns = "/reject") // "Servlet" pieslēgšana saitei
public class RejectProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {  // kļūdu apstrāde, kuras veidojas SQL pieprasījumā
            DAO.rejectProduct(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/products");
    } // Pēc šis saites: <a href="reject?id=${product.id}">reject</a> tiek nodotas ID vērtības, kura tālāk tiek nodota "rejectProduct" metodei, kura atrodas DAO klasē
}   // Veikta datu apstrāde, kuras rezultātā tiek nomainīts produkta stutuss pēc produkta ID uz "Rejected"
