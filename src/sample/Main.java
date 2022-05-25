package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String res = "";

        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        int cnt = 0;

        res += "<html>" +
                "<head>" +
                    "<title>Server State</title> " +
                    "<meta charset='utf-8'>" +
                    "<style> .header {fontWeight: bold;} " +
                        ".data {font-style: italic;}" +
                        ".table{border: 1px solid #000;width:200px;display:flex;justify-content:space-around;flex-wrap:wrap}" +
                        ".flex{display:flex;width:200px;justify-content:space-around}" +
                    "</style>" +
                "</head>";

        res += "<body> " +
                    "<div class=\"table\">" +
                        "<div class=\"flex\">" +
                            "<span class=\"header\"><b>OS name: </b></span>" +
                            "<span class=\"header\">" + osName + " </span>" +
                        "</div>" +
                        "<div class=\"flex\">" +
                            "<span class=\"data\"><b>Os arch: </b></span>" +
                            "<span class=\"data\"> " + osArch + " </span>" +
                        "</div>" +
                    "</div>" +
                    "<div class=\"table\">" +
                        "<span class=\"data\"> Connect №: </span>";

        try (ServerSocket soc = new ServerSocket(8080)) {
            cnt++;
            res +=  "<span class=\"data\"> " + cnt + " </span>" +
                    "</div>" +
                    "</body>" +
                    "</html>";
            for (;;) {
                Socket clisoc = soc.accept();
                Client cli = new Client(clisoc, res);
            }
        } catch (IOException e) {
            System.out.println("Error to server Socket Open!!!");
        }

    }
}
