/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.AddEditEmployeeLogic;
import transferobjects.Department;
import transferobjects.DepartmentEmployee;
import transferobjects.Employee;
import transferobjects.Salary;
import transferobjects.Title;

/**
 *
 * @author alexm
 */
@WebServlet(name = "EmployeeModifyView", urlPatterns = {"/EmployeeModifyView"})
public class EmployeeModifyView extends HttpServlet {

    AddEditEmployeeLogic logic = new AddEditEmployeeLogic();
    
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
            out.print(WebHelper.htmlHeader("Employees"));
            out.print(WebHelper.htmlBodyStart("Employee modification", "You can bend the will of your employees here."));
            //AddEditEmployeeLogic logic = new AddEditEmployeeLogic();
            int id = Integer.parseInt(request.getParameter("id"));
            Employee emp = logic.getEmployeeById(id);
            Salary salary = logic.getEmployeeSalary(id);
            Title title = logic.getEmployeeTitle(id);
            Department dept = logic.getEmployeeDepartment(id);
            DepartmentEmployee deptEmp = logic.getDepartmentEmployee(id);
            boolean isManager = logic.isEmployeeManager(id, dept.getNumber());
            
            out.println("<form id=\"empForm\" method=\"post\">");
            
            //employee info **************************
            out.println("<div class=\"card mb-3\">");
            out.println("<div class=\"card-header\"><h6>Employee information</h6></div>");
            out.println("<div class=\"row mt-3 mr-3 ml-3\">");
            out.println("<div class=\"col-sm-6\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"first_name\">First name</label>");
            out.println("<input class=\"form-control\" type=\"textbox\" name=\"first_name\" value=\"" + emp.getFirstName() + "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-6\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"last_name\">Last name</label>");
            out.println("<input class=\"form-control\" type=\"textbox\" name=\"last_name\" value=\"" + emp.getLastName()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"row mr-3 ml-3\">");
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"birth_date\">Birth date</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"birth_date\" value=\"" + emp.getBirthDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"hire_date\">Hire date</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"hire_date\" value=\"" + emp.getHireDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<label>Gender</label>");
            out.println("<div class=\"form-group\">");
            out.println("<div class=\"form-check-inline\">");
            out.println("<input id=\"gender_m\" class=\"form-check-input\" type=\"radio\" name=\"gender\" value=\"M\" " + (emp.getGender().equals("M") ? "checked" : "") + "/>");
            out.println("<label class=\"form-check-label\" for=\"gender_m\">Male</label>");
            out.println("</div>");
            out.println("<div class=\"form-check-inline\">");
            out.println("<input id=\"gender_f\" class=\"form-check-input\" type=\"radio\" name=\"gender\" value=\"F\" " + (emp.getGender().equals("F") ? "checked" : "") + "/>");
            out.println("<label class=\"form-check-label\" for=\"gender_f\">Female</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</div>");// /row
            out.println("</div>");// /card
            //employee info **************************
            
            //title info *****************************
            out.println("<div class=\"card mb-3\">");
            out.println("<div class=\"card-header\"><h6>Title information</h6></div>");
            out.println("<div class=\"row mt-3 mr-3 ml-3\">");
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"title\">Title</label>");
            out.println("<input class=\"form-control\" type=\"textbox\" name=\"title\" value=\"" + title.getTitle()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"title_from_date\">From</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"title_from_date\" value=\"" + title.getFromDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"title_to_date\">To</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"title_to_date\" value=\"" + title.getToDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</div>"); // /row
            out.println("</div>");// /card
            //title info *****************************
            
            //salary info ****************************
            out.println("<div class=\"card mb-3\">");
            out.println("<div class=\"card-header\"><h6>Salary information</h6></div>");
            out.println("<div class=\"row mt-3 mr-3 ml-3\">");
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"salary\">Salary</label>");
            out.println("<input class=\"form-control\" type=\"textbox\" name=\"salary\" value=\"" + salary.getSalary()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"salary_from_date\">From</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"salary_from_date\" value=\"" + salary.getFromDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"salary_to_date\">To</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"salary_to_date\" value=\"" + salary.getToDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</div>"); // /row
            out.println("</div>"); // /card
            //salary info ****************************
            
            //department info ************************
            out.println("<div class=\"card mb-3\">");
            out.println("<div class=\"card-header\"><h6>Department information</h6></div>");
            out.println("<div class=\"row mt-3 mr-3 ml-3\">");
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"departmentSelector\">Department</label>");
            out.println("<select class=\"custom-select\" id=\"departmentSelector\">");
            for (Department d : logic.getDepartments()){
                if (d.equals(dept)){
                    out.println("<option value=\"" + d.getNumber() + "\" selected>" + d.getName() + "</option>");
                } else {
                    out.println("<option value=\"" + d.getNumber() + "\">" + d.getName() + "</option>");
                }
            }            
            out.println("</select>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"dept_from_date\">From</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"dept_from_date\" value=\"" + deptEmp.getFromDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"col-sm-4\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"dept_to_date\">To</label>");
            out.println("<input class=\"form-control\" type=\"date\" name=\"dept_to_date\" value=\"" + deptEmp.getToDate()+ "\"/>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</div>"); // /row
            out.println("</div>"); // /card
            //department info ************************
            
            out.println(WebHelper.getSaveResetButtons());
            out.println("</form>");            
            
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
        
        Map<String, String[]> map = request.getParameterMap();
        
        try {
            logic.updateEmployee(map);
            
        } catch (IllegalArgumentException iae) {
            Logger.getLogger(EmployeeModifyView.class.getName()).log(Level.SEVERE, null, iae);
        }
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
