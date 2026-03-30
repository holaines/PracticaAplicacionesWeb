import java.io.*;
import java.util.*;
import java.awt.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import activities.db.*;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class confirmacion extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("GET Request. No Form Data Posted");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String login;
        String passwd;
        String name;
        String surname;
        String address;
        String phone;
        
	login=req.getParameter("login");
        passwd=req.getParameter("passwd");
        name=req.getParameter("name");
        surname=req.getParameter("surname");
        address=req.getParameter("address");
        phone=req.getParameter("phone");

        Cookie  Cookielogin = new Cookie("login", login);
        res.addCookie(Cookielogin);

        Cookie  Cookiepasswd= new Cookie("passwd", passwd);
        res.addCookie(Cookiepasswd);

        Cookie  Cookiename = new Cookie("name", name);
        res.addCookie(Cookiename);

        Cookie  Cookiesurname = new Cookie("surname", surname);
        res.addCookie(Cookiesurname);

        Cookie  Cookieaddress = new Cookie("address", address);
        res.addCookie(Cookieaddress);

        Cookie  Cookiephone = new Cookie("phone", phone);
        res.addCookie(Cookiephone);


        res.sendRedirect("confirmacion.jsp");

    }//doPost end
}//class end