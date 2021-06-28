import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

import java.io.IOException;

public class Students {
    HttpServer server;

    public static void main(String[] args){
        System.out.println("Server has started");

        Students students = new Students();
        students.init();
    }
    public  void  init() {
        try{
            server= HttpServer.create(new InetSocketAddress("localhost", 8001),0);
            server.createContext("/studies", new StudentsHttp());
            server.start();
        }catch(IOException ex) {
            System.out.println("Server error" + ex);

        }
    }
}
