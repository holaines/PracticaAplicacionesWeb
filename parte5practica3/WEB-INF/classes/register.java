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


public class register extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("GET Request. No Form Data Posted");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        Cookie[] cookies = req.getCookies();
        String login ="";
        String passwd ="";
        String name ="";
        String surname ="";
        String address ="";
        String phone ="";
        PrintWriter out = res.getWriter();

        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login")){
                login=cookie.getValue();
            }
            if (cookie.getName().equals("passwd")){
                passwd=cookie.getValue();
            }
            if (cookie.getName().equals("name")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("surname")){
                surname=cookie.getValue();
            }
            if (cookie.getName().equals("address")){
                address=cookie.getValue();
            }
            if (cookie.getName().equals("phone")){
                phone=cookie.getValue();
            }
        }

        String action = req.getParameter("action");
        if (action.equals("Si")){
            try{
                DBInteraction db=new DBInteraction();
                if(db.check_login(login)){
                    String msg = "Uusuario ya existe";
                    Cookie Cookierror = new Cookie("error", msg);
                    res.addCookie(Cookierror);
                    res.sendRedirect("register.jsp");
                }else{
                    db.addusr(login, passwd,  name,  surname,  address,  phone);
                    db.close();
        		    res.sendRedirect("login.html");
                }
	        }
            catch (Exception e){ out.println(e);}
        }
        else{
            res.sendRedirect("register.jsp");
        }
	}//doPost end
}//class end

