package es.mendezsergio.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.mendezsergio.entities.Oferta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class OfertaService {

    static final String PATH = "/api/ofertas";
    static ObjectMapper mapper = new ObjectMapper();

    static public ArrayList<Oferta> findAllOfertas(String url, String token) {

        ArrayList<Oferta> listaOfertas = new ArrayList<>();

        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH))
                    .setHeader("Content-Type",  "application/json")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            ArrayList listResponse = mapper.readValue(response.body(), ArrayList.class);

            listResponse.forEach(x -> {
                Oferta oferta = mapper.convertValue(x, Oferta.class);
                listaOfertas.add(oferta);
            });

            return listaOfertas;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    static public Oferta findOferta(String url, Long id, String token) {

        Oferta oferta;

        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url + PATH +"/" + id))
                    .setHeader("Content-Type",  "application/json")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            Oferta ofertaResponse = mapper.readValue(response.body(), Oferta.class);

            return ofertaResponse;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createOferta(String url, Oferta oferta) {
    //  TODO
    }

    public void putOferta(String url, Oferta oferta) {
    //  TODO
    }

    public void deleteOferta(String url, Oferta oferta) {
    //  TODO
    }

    public void deleteAllOfertas(String url) {
    //  TODO
    }

}
