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


public class login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("GET Request. No Form Data Posted");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String Usuario;
        String Contraseña;

        //Call for a reference for data base access
        ArrayList data = new ArrayList();
        //Retrieve the parameters from the form
        Usuario=req.getParameter("Usuario");
        Contraseña=req.getParameter("Contraseña");


        PrintWriter out = res.getWriter();

        try{
            DBInteraction db=new DBInteraction();
            boolean autenticarse = db.authentication( Usuario, Contraseña);
            db.close();
            if (autenticarse ==true) {
                res.sendRedirect("search.html");
            } else {
                out.println("usuario no existe :(");
            }
        } //end try
        catch (Exception e){  }
    }//doPost end
}//class end