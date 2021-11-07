package es.mendezsergio.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.mendezsergio.entities.Tecnologia;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class TecnologiaService {

    static final String PATH = "/api/tecnologias";
    static ObjectMapper mapper = new ObjectMapper();

    static public ArrayList<Tecnologia> findAllTecnologias(String url, String token) {

        ArrayList<Tecnologia> listaTecnologias = new ArrayList<>();

        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH))
                    .setHeader("Content-Type",  "application/json")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            ArrayList listResponse = mapper.readValue(response.body(), ArrayList.class);

            listResponse.forEach(x -> {
                Tecnologia tecnologia = mapper.convertValue(x, Tecnologia.class);
                listaTecnologias.add(tecnologia);
            });

            return listaTecnologias;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    static public Tecnologia findTecnologia(String url, Long id, String token) {

        Tecnologia tecnologia;

        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH +"/" + id))
                    .setHeader("Content-Type",  "application/json")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            Tecnologia tecnologiaResponse = mapper.readValue(response.body(), Tecnologia.class);

            return tecnologiaResponse;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createTecnologia(String url, Tecnologia tecnologia) {
    //  TODO
    }

    public void putTecnologia(String url, Tecnologia tecnologia) {
    //  TODO
    }

    public void deleteTecnologia(String url, Tecnologia tecnologia) {
    //  TODO
    }

    public void deleteAllTecnologias(String url) {
    //  TODO
    }

}
