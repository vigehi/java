import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


public class StudentsHttp implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange){
        System.out.println("Server communicated with the handle");
        handleResponse(httpExchange);// method
    }
    private void handleResponse(HttpExchange httpExchange){
        StudentsDbConnection dbConnection = new StudentsDbConnection();
        dbConnection.DbConnect();
        String resp = dbConnection.getStudentsInfo();//method
        dbConnection.close();

        try {
            OutputStream outputStream = httpExchange.getResponseBody();
            StringBuilder createHtml=new StringBuilder(); //html builder method
            createHtml.append("<html>")
                    .append("<body>")
                    .append("<h1>")
                    .append("Student Grade Info On The Web")
                    .append("<h1>")
                    .append(resp)
                    .append("</body>")
                    .append("</html>");
            String htmlResponse=createHtml.toString();

            httpExchange.sendResponseHeaders(200, htmlResponse.length());
            outputStream.write(htmlResponse.getBytes());
            outputStream.flush();
            outputStream.close();


        }catch (IOException ex ){
            System.out.println("Server error"+ex);

        }
    }
}
