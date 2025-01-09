import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

public class Server {
    private static final Graph graph = new Graph();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/add-edge", Server::handleAddEdge);
        server.createContext("/shortest-path", Server::handleShortestPath);
        server.setExecutor(null);
        server.start();
        System.out.println("Server is running on port 8080...");
    }

    private static void handleAddEdge(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String body = reader.readLine();
            String[] parts = body.split("&");

            String source = parts[0].split("=")[1];
            String destination = parts[1].split("=")[1];
            int weight = Integer.parseInt(parts[2].split("=")[1]);

            graph.addEdge(source, destination, weight);

            String response = "Edge added successfully!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    private static void handleShortestPath(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String query = exchange.getRequestURI().getQuery();
            String[] parts = query.split("&");

            String start = parts[0].split("=")[1];
            String end = parts[1].split("=")[1];

            Map<String, Object> result = graph.findShortestPath(start, end);

            String response = "Path: " + result.get("path") + "\nDistance: " + result.get("distance");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
