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
import logic.DepartmentManagerLogic;
import transferobjects.DepartmentManager;

/**
 *
 * @author kylem
 */
@WebServlet(name = "DepartmentManagerView", urlPatterns = {"/DepartmentManagerView"})
public class DepartmentManagerView extends HttpServlet {

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
            out.print(WebHelper.htmlHeader("Department Managers"));
            out.print(WebHelper.htmlBodyStart("Department Managers"));
            DepartmentManagerLogic logic = new DepartmentManagerLogic();
            List<DepartmentManager> deptManagers = logic.getAllDepartmentManagers();
            out.println("<table class=\"table\">");
            out.println("<tr>");
            out.println("<th>Employee Number</th>");
            out.println("<th>Department Number</th>");
            out.println("<th>From Date</th>");
            out.println("<th>To Date</th>");
            out.println("</tr>");
            for(DepartmentManager deptManager : deptManagers){
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        deptManager.getEmployeeNumber(),
                        deptManager.getDepartmentNumber(),
                        deptManager.getFromDate(),
                        deptManager.getToDate());
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
