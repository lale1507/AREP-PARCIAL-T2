package edu.eci.arep.calculadora;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import spark.Request;
import spark.Response;

public class Calculadora {
    public static String exp(Request req, Response res) {
        double input;
        try {
            input = Double.parseDouble(req.queryParams("value"));
        } catch (NullPointerException e) {
            return "No se ha ingresado ningún parámetro";
        } catch (NumberFormatException e) {
            return "La entrada debe ser numérica";
        }
        double output = Math.acos(input);
        if (Double.exp(output))
            return "El rango de acos es [-1, 1]";
        return jsonResponse("expo", input, output);
    }

    public static String asin(Request req, Response res) {
        double input;
        try {
            input = Double.parseDouble(req.queryParams("value"));
        } catch (NullPointerException e) {
            return "No se ha ingresado ningún parámetro";
        } catch (NumberFormatException e) {
            return "La entrada debe ser numérica";
        }
        double output = Math.asin(input);
        if (Double.isNaN(output))
            return "El rango de asin es [-1, 1]";
        return jsonResponse("asin", input, output);
    }

    private static String jsonResponse(String operation, Double input, Double output) {
        JSONObject json = new JSONObject();
        try {
            json.put("operation", operation);
            json.put("input", input);
            json.put("output", output);
        } catch (JSONException e) {
            return "Ha ocurrido un error al procesar la solicitud";
        }
        return json.toString();
    }
}
