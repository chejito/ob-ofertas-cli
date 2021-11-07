package es.mendezsergio.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.mendezsergio.entities.UserLogin;
import es.mendezsergio.entities.UserRegister;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class AuthenticationService {

    static ObjectMapper mapper = new ObjectMapper();

    static public String login(String url, UserLogin user) {
        final String PATH_LOGIN = "/api/login";
        String token = "";

        try {

            String jsonString = mapper.writeValueAsString(user);
//            System.out.println(jsonString);

            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH_LOGIN))
                    .setHeader("Content-Type",  "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            Map arrayResponse = mapper.readValue(response.body(), Map.class);
            token = arrayResponse.get("token").toString();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return token;
    }

    static public void register(String url, UserRegister userRegister) {
        final String PATH_LOGIN = "/api/register";

        try {

            String jsonString = mapper.writeValueAsString(userRegister);
            System.out.println(jsonString);

            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH_LOGIN))
                    .setHeader("Content-Type",  "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            Map arrayResponse = mapper.readValue(response.body(), Map.class);

            System.out.println(arrayResponse.toString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
