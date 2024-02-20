package Servlet;

import Connector.Item;
import Database.ItemDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/detailItem")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Item item = ItemDB.getItemById(Long.parseLong(id));
        req.setAttribute("detailAItem", item);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
