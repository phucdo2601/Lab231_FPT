/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.google;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author ASUS
 */
public class GmailUtils {
    
    public static String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GoogeConstant.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", GoogeConstant.GOOGLE_CLIENT_ID)
                        .add("client_secret", GoogeConstant.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GoogeConstant.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GoogeConstant.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }
    
     public static GoogleAccDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GoogeConstant.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        GoogleAccDTO googlePojo = new Gson().fromJson(response, GoogleAccDTO.class);
        return googlePojo;
    }
}
