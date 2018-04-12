/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.DepartmentLogic;
import transferobjects.Department;

/**
 *
 * @author kyle
 */
@WebServlet(name = "DepartmentView", urlPatterns = {"/DepartmentView"})
public class DepartmentView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            /* TODO output your page here. You may use following sample code. */
            out.print(WebHelper.htmlStart());
            out.print(WebHelper.htmlHeader("Departments"));
            out.print(WebHelper.htmlBodyStart("Departments", "Clicking on the department number will allow you to edit that record."));
            DepartmentLogic logic = new DepartmentLogic();
            List<Department> departments = logic.getAllDepartments();
            out.println("<table class=\"table table-hover\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">Department Number</th>");
            out.println("<th scope=\"col\">Department Name</th>");
            out.println("</tr>");
            out.println("</thead>");
            for(Department department : departments){
                out.printf("<tr><td><a href=\"%s\">%s</a></td><td>%s</td></tr>",
                        "departments/update/" + department.getNumber(),
                        department.getNumber(),
                        department.getName());
            }
            out.println("</table>");
            out.print(WebHelper.htmlBodyEnd());
            out.print(WebHelper.htmlEnd());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
