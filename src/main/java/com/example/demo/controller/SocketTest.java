package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @NAME: SocketTest
 * @USER: 77027
 * @DATE: 2020/12/18
 * @TIME: 10:13
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        int port = 8080;//server 端口采用8080
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            while (true) {
                socket = server.accept();
                new Thread(new TimeHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.close();
                server = null;
                System.out.println("the time server close...");
            }
        }
    }

    static class TimeHandler implements Runnable {

        private Socket socket;

        public TimeHandler() {

        }

        public TimeHandler(Socket socket) {
            this();
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start success...");
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    String str = in.readLine();
                    if ("end".equals(str)) {
                        break;
                    }
                    String time = str + ":" + System.currentTimeMillis();
                    out.println(time);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in = null;
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }

        }
    }

}
