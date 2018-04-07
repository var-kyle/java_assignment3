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
import logic.EmployeeLogic;
import transferobjects.Employee;

/**
 *
 * @author kylem
 */
@WebServlet(name = "EmployeeView", urlPatterns = {"/EmployeeView"})
public class EmployeeView extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeView at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet DepartmentManagerView at " + request.getContextPath() + "</h1>");
            EmployeeLogic logic = new EmployeeLogic();
            List<Employee> employees = logic.getAllEmployees();
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Employee Number</td>");
            out.println("<td>Birth Date</td>");
            out.println("<td>First Name</td>");
            out.println("<td>Last Name</td>");
            out.println("<td>Gender</td>");
            out.println("<td>Hire Date</td>");
            out.println("</tr>");
            for(Employee employee : employees){
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        employee.getEmployeeNumber(),
                        employee.getBirthDate(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getGender(),
                        employee.getHireDate());
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
