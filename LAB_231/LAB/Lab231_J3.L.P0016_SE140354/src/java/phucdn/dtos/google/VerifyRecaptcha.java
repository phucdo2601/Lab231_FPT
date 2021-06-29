/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.google;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author ASUS
 */
public class VerifyRecaptcha {

    public static boolean verifyRacapt(String gRecaptchaResponse) throws IOException {
        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        }

        URL obj = new URL(GoogeConstant.RECAPTCHA_URL);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", GoogeConstant.USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String postParams = "secret=" + GoogeConstant.RECAPTCHA_SECRET + "&response="
                + gRecaptchaResponse;

        //send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        //parse JSON response and return 'success' value
        JsonReader jsReader = Json.createReader(new StringReader(response.toString()));
        JsonObject jsObject = jsReader.readObject();
        jsReader.close();
        return jsObject.getBoolean("success");

    }
}
