package backend;

import backend.server.*;
import backend.database.*;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static Database db;
    public static void main(String[] args) throws IOException {
        // ServerEngine.connectToServer();
        int port = 8187;
        db = new Database();
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8187), 0);
        server.setExecutor(Executors.newFixedThreadPool(10));

        server.createContext("/", new RootHandler(port));
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());

        server.start();
        System.out.println("HTTP Server is started");

        // ServerEngine.connectToServerMultiple();
    }

}


