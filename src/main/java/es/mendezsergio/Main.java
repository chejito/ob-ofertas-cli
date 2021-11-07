package es.mendezsergio;

import es.mendezsergio.entities.Oferta;
import es.mendezsergio.entities.Tecnologia;
import es.mendezsergio.entities.UserLogin;
import es.mendezsergio.entities.UserRegister;
import es.mendezsergio.services.AuthenticationService;
import es.mendezsergio.services.OfertaService;
import es.mendezsergio.services.TecnologiaService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        final String ADMIN_USER = System.getenv("MI_ADMIN_USER"); // Sustituir por username
        final String ADMIN_PASS = System.getenv("MI_ADMIN_PASS"); // Sustituir por password
        final String URL = "https://proyecto-ofertas-ob.herokuapp.com";

//        En caso de querer crear un usuario nuevo e iniciar sesión en la aplicación con él
        /*UserRegister userRegister = new UserRegister("sergio", "1234", "sergio@example.com");
        AuthenticationService.register(url, userRegister);
        UserLogin userLogin = new UserLogin(userRegister.getUsername(), userRegister.getPassword());
        String token = AuthenticationService.login(URL, userLogin);*/

//        En caso de tener ya un usuario registrado
        UserLogin userLoginAdmin = new UserLogin(ADMIN_USER, ADMIN_PASS);

        String token = AuthenticationService.login(URL, userLoginAdmin);
        System.out.println("Token: " + token);

//        Prueba de los métodos findAllTecnologias y findTecnologia de TecnologiaService
        System.out.println("\nListar todas las tecnologías");
        System.out.println("----------------------------");

        ArrayList<Tecnologia> tecnologias = (ArrayList) TecnologiaService.findAllTecnologias(URL, token);

        tecnologias.forEach( x ->  System.out.println("Tecnología " + x.getId() + ": " + x.getNombre()));

        System.out.println("\nListar la tecnología con id: 2");
        System.out.println("------------------------------");

        Tecnologia tecnologia1 = TecnologiaService.findTecnologia(URL, 2L, token);

        System.out.println("Tecnología " + tecnologia1.getId() + ": " + tecnologia1.getNombre());

//        Prueba de los métodos findAllOfertas y findOferta de OfertaService
        System.out.println(" \nListar todas las ofertas");
        System.out.println("----------------------------");

        ArrayList<Oferta> ofertas = (ArrayList) OfertaService.findAllOfertas(URL, token);

        ofertas.forEach( x ->  System.out.println("Oferta " + x.getId() + ": " + x.getNombre()));

        System.out.println("\nListar la oferta con id: 3");
        System.out.println("------------------------------");

        Oferta oferta4 = OfertaService.findOferta(URL, 3L, token);

        System.out.println("Oferta " + oferta4.getId() + ": " + oferta4.getNombre());

//        Prueba del método createTecnologia de TecnologiaService y createOferta de OfertaService
        /*Tecnologia tecJava = new Tecnologia("Java");
        Tecnologia tecSpring = new Tecnologia( "Spring");
        Tecnologia tecJS = new Tecnologia("Javascript");
        Tecnologia tecAngular = new Tecnologia("Angular");
        Tecnologia tecCSS = new Tecnologia("CSS");
        Tecnologia tecPython = new Tecnologia("Python");
        Tecnologia tecReact = new Tecnologia("React");
        Tecnologia tecDjango = new Tecnologia("Django");

        Set<Tecnologia> tecnologias1 = new HashSet<>();
        Set<Tecnologia> tecnologias2 = new HashSet<>();
        Set<Tecnologia> tecnologias3 = new HashSet<>();

        tecnologias1.addAll(Arrays.asList(tecJava, tecSpring));
        tecnologias2.addAll(Arrays.asList(tecJS, tecAngular, tecCSS));
        tecnologias3.addAll(Arrays.asList(tecJS, tecCSS, tecReact, tecPython, tecDjango));

        tecnologias1.forEach(System.out::println);
        tecnologias2.forEach(System.out::println);
        tecnologias3.forEach(System.out::println);

        Date fecha1 = new Date (20/12/23);
        Date fecha2 = new Date (21/10/7);
        Date fecha3 = new Date (21/2/28);

        Oferta oferta1 = new Oferta(null, tecnologias1,"Desarrollador Backend Jr.", "Orange","Comunicaciones",
                4,"Barcelona",12000,18000,
                "Presencial",2,
                "Ingeniero","Frontend","Indefinido" ,fecha1,true,"") ;

        Oferta oferta2 = new Oferta(null, tecnologias2, "Desarrollador Frontend Jr.","Vodafone","Comunicaciones",
                2,"Madrid",11000,16000,
                "Remoto",1,
                "CFGS","Frontend","Practicas" ,fecha2,false,"");

        Oferta oferta3 = new Oferta(null, tecnologias3,"Desarrollador Fullstack Sr.","Movistar", "Comunicaciones",
                2, "Zaragoza", 14000, 19000,
                "Remoto", 3,
                "CFGS", "Fullstack", "Practicas", fecha3, true, "");


        Set<Oferta> ofertas = new HashSet<>();
        ofertas.addAll(Arrays.asList(oferta1, oferta2, oferta3));*/

    }
}
