package ru.job4j.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Class EchoServer решение задачи  0. Видео[4850#143752] программа "ЭхоСервер"
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) { Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if(str.contains("GET")) {
                            int index0 = str.indexOf("=");
                            int index1 = str.indexOf("HTTP");
                            index0 = index0 + 1;
                            index1 = index1 - 1;
                            String str1 = str.substring(index0, index1);
                            if (str1.equals("Bye")) {
                                in.close();
                                out.close();
                                socket.close();
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}

