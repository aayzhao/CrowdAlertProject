package backend;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class ServerEngine {
    public static final int max_con = 3;
    public static final int port = 8187;
    public static void connectToServer() {
        //Try to connect to the server on an unused port e.g. 9991. A successful connection will return a socket
        try(ServerSocket serverSocket = new ServerSocket(9991)) {
            Socket connectionSocket = serverSocket.accept();

            //Create Input&Outputstreams for the connection
            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, StandardCharsets.UTF_8);
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, StandardCharsets.UTF_8), true);

            serverPrintOut.println("Hello World! Enter Peace to exit.");

            //Have the server take input from the client and echo it back
            //This should be placed in a loop that listens for a terminator text e.g. bye
            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverPrintOut.println("Echo from <Your Name Here> Server: " + line);

                if(line.toLowerCase().trim().equals("peace")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectToServerMultiple() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < max_con; i++) {
            ServerSocket finalServerSocket = serverSocket;
            //Create the thread
            Runnable runnable = () -> {
                try {
                    Socket listenerSocket = finalServerSocket.accept();
                    InputStream inputToServer = listenerSocket.getInputStream();
                    OutputStream outputFromServer = listenerSocket.getOutputStream();

                    Scanner input = new Scanner(inputToServer, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

                    printWriter.println("Welcome Minion! I'll multiply the number you give by 10.\n Type -19 to quit");
                    printWriter.println("I'm Running on Thread: " + Thread.currentThread().getName());

                    boolean done = false;
                    while(!done && input.hasNextLine()) {
                        String line = input.nextLine();
                        double inputDouble = 0;

                        try{
                            inputDouble = Double.parseDouble(line);
                            //If input is -19 or line == null, terminate and close socket
                            if(line == null || inputDouble == -19) {
                                done = true;
                                printWriter.println("Sad to see you leave! ... Closing Connection!");
                                listenerSocket.close();
                            }
                            printWriter.println("Your answer is: " + inputDouble * 10);
                        }catch (Exception ex) {
                            printWriter.println(":{( - Only insert numbers!!!");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            //Execute the runnables!
            Executors.newCachedThreadPool().execute(runnable);
        }
    }
}
