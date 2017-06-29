package cn.gavin.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoAjaxServlet extends HttpServlet {  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        try {  
            response.setContentType("text/html");  
            response.setHeader("Cache-Control", "no-store");  
            response.setHeader("Pragma", "no-cache");  
            response.setDateHeader("Expires", 0);  
            String name = request.getParameter("userName");  
            if(name.equals("1")) {  
                out.write("OK");  
            }  
            else {  
                out.write("NO");  
            }  
        } finally {   
            out.close();  
        }  
    }   
  
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
        processRequest(request, response);  
    }   
  
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
        processRequest(request, response);  
    }  
  
    @Override  
    public String getServletInfo() {  
        return "Short description";  
    }  
  
}  
