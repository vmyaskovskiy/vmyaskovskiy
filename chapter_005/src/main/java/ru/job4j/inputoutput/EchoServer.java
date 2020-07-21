package ru.job4j.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Class EchoServer решение задачи  1. Бот[7921#143753]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    str = in.readLine();
                            int index0 = str.indexOf("=");
                            int index1 = str.indexOf("HTTP");
                            index0 = index0 + 1;
                            index1 = index1 - 1;
                            String str1 = str.substring(index0, index1);
                            if (str1.equals("Exit")) {
                                server.close();
                            } else {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                System.out.println("str1 = " + str1);
                                out.write(str1.getBytes());
                            }
                }
            }
        }
    }
}

