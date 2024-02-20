package Servlet;

import Connector.Item;
import Database.ItemDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addItem")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(Double.parseDouble(price));
        ItemDB.addItem(item);
        resp.sendRedirect("/mser");
    }
}
