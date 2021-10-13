package edu.eci.arep.calculadora;

import static spark.Spark.port;
import static spark.route.HttpMethod.get;
import edu.eci.arep.calculadora.Calculadora;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        port(getPort());
        get("/acos", Calculadora::exp);
        get("/asin", Calculadora::asin);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set
    }
}
