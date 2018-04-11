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

    private static final String BOOTSTRAP_CSS = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">";
    private static final String BOOSTRAP_JS = "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>";
    private static final String JQUERY = "<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>";
    
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
                .append("<link rel=\"stylesheet\" href=\"style.css\">")
                .append(BOOTSTRAP_CSS)
                .append(JQUERY)
                .append(BOOSTRAP_JS)
                .append("</head>")
                .toString();
    }

    public static String htmlBodyStart(String title) {
        StringBuilder sb = new StringBuilder();

        return sb.append("<body>")
                .append("<div class=\"container\">")
                .append("<div class=\"py-5 text-center\">")
                .append("<h2>")
                .append(title)
                .append("</h2>")
                .append("</div>")
                .append("<div class=\"row\">")
                .toString();
    }
    
    public static String htmlBodyEnd() {
        StringBuilder sb = new StringBuilder();
        
        return sb.append("</div>") // /row
                .append("</div>") // /container
                .append("</body>") // /body
                .toString();
    }
}
