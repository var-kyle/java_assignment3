/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author kyle
 */
public class WebHelper {

    private static final String BOOTSTRAP_CSS = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">";
    private static final String BOOSTRAP_JS = "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>";
    private static final String JQUERY = "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>";
    private static final String POPPER_JS = "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>";
    
    public static String htmlStart() {
        StringBuilder sb = new StringBuilder();

        return sb.append("<!DOCTYPE html>")
                .append("<html>")
                .toString();
    }

    public static String htmlEnd() {
        StringBuilder sb = new StringBuilder();

        return sb.append("</html>")
                .toString();
    }

    public static String htmlHeader(String title) {
        StringBuilder sb = new StringBuilder();

        return sb.append("<head>")
                .append("<title>")
                .append(title)
                .append("</title>")
                .append("<meta charset=\"UTF-8\">")
                .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                .append("<link rel=\"stylesheet\" href=\"/assignment3/style.css\">")
                .append(BOOTSTRAP_CSS)
                .append(JQUERY)
                .append(POPPER_JS)
                .append(BOOSTRAP_JS)
                .append("</head>")
                .toString();
    }

    public static String htmlBodyStart(String title, String subtitle) {
        StringBuilder sb = new StringBuilder();

        return sb.append("<body>")
                .append(getNavbar())
                .append("<main class=\"container\">")
                .append("<div class=\"py-5 text-center\">")
                .append("<h2>")
                .append(title)
                .append("</h2>")
                .append("<p class=\"lead\">")
                .append(subtitle)
                .append("</p>")
                .append("</div>")
                .append("<div class=\"row\">")
                .toString();
    }
    
    public static String htmlBodyEnd() {
        StringBuilder sb = new StringBuilder();
 
        return sb.append("</div>") // /row
                .append("</main>") // /container
                .append("<footer class=\"footer bg-dark\">")
                .append("<div class=\"container text-center\">")
                .append("<span class=\"text-light\">&copy;2018</span>")
                .append("</div>")
                .append("</footer>")
                .append("</body>") // /body
                .toString();
    }
    
    public static String getSaveResetButtons() {
        StringBuilder sb = new StringBuilder();

        return sb.append("<div class=\"row\">")
                .append("<div class=\"col-sm-12\">")
                .append("<input class=\"btn btn-primary mr-3\" type=\"submit\" value=\"Save\"/>")
                .append("<input class=\"btn btn-default\" type=\"reset\" value=\"Reset\"/>")
                .append("</div>")
                .append("</div>")
                .toString();
    }
    
    private static String getNavbar(){
        StringBuilder sb = new StringBuilder();
   
        return sb.append("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">")
                .append("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">")
                .append("<span class=\"navbar-toggler-icon\"></span>")
                .append("</button>")
                .append("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">")
                .append("<ul class=\"navbar-nav mr-auto\">")
                .append("<li class=\"nav-item\">")
                .append("<a class=\"nav-link\" href=\"/assignment3/index.html\">Home</a>")
                .append("</li>")
                .append("<li class=\"nav-item dropdown\">")
                .append("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Tables</a>")
                .append("<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Departments\">Departments</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/DepartmentEmployees\">Department employees</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/DepartmentManagers\">Department managers</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Employees\">Employees</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Salaries\">Salaries</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Titles\">Titles</a>")
                .append("</div>")
                .append("</li>")
                .append("<li class=\"nav-item dropdown\">")
                .append("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Forms</a>")
                .append("<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Departments/Add\">Add department</a>")
                .append("<a class=\"dropdown-item\" href=\"/assignment3/Employees/Add\">Add employee</a>")
                .append("</div>")
                .append("</li>")
                .append("</ul>")
                //.append("<form class=\"form-inline my-2 my-lg-0\">")
                //.append("<input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"I don't do anything!\" aria-label=\"Search\">")
                //.append("<button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>")
                //.append("</form>")
                .append("</div>")
                .append("</nav>")
                .toString();
    }
}
