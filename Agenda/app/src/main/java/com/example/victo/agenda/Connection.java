package com.example.victo.agenda;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by victor on 22/04/2018.
 */

public class Connection {
    private final String USER_AGENT = "Mozilla/5.0";
    StringBuffer response;

    // HTTP GET request
    public Cep sendGet(String cepStr) throws Exception {
        String url = "https://viacep.com.br/ws/"+cepStr+"/json/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Cep cep = null;
        try {
            JSONObject cepObj = new JSONObject(response.toString());
            cep = (new Cep(cepObj.getString("cep"),
                    cepObj.getString("logradouro")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cep;
    }
}
