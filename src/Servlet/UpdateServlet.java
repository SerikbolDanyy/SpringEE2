package Servlet;

import Connector.Item;
import Database.ItemDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateItem")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Получаем данные из формы
            long itemId = Long.parseLong(request.getParameter("itemId"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            // Создаем объект Item
            Item updatedItem = new Item();
            updatedItem.setId(itemId);
            updatedItem.setName(name);
            updatedItem.setDescription(description);
            updatedItem.setPrice(price);

            // Обновляем элемент в базе данных
            ItemDB itemDB = new ItemDB();
            itemDB.updateItem(updatedItem);

            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
