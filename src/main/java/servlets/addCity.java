package servlets;

import db.DBManager;
import model.City;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCity", value = "/addCity")
public class addCity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String name=request.getParameter("cityName");
     String code=request.getParameter("cityCode");
        System.out.println(name+code);
     City city=new City(null,name,code);
     DBManager.addCity(city);
     response.sendRedirect("/cities");
    }
}
