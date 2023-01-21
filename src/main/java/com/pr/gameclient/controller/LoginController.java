package com.pr.gameclient.controller;

import com.pr.gameclient.models.Player;
import com.pr.gameclient.helpers.HTTPClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginController {

    public Player LoginAction(String user, String password) throws Exception{
        String toSend = "{\"email\": \"" + user + "\",\"password\": \"" + password + "\"}";
        String responseString = HTTPClient.post("http://localhost:8080/api/login", toSend);

        if(responseString.contains("error")){throw new Exception();}

        String filteredResponseString = responseString.substring(responseString.lastIndexOf("id"));
        filteredResponseString = filteredResponseString.substring(4, filteredResponseString.length() - 1);
        Long Id = Long.parseLong(filteredResponseString);
        Player returnPlayer = new Player(user, 0, Id);
        //print result
        System.out.println(responseString);
        return returnPlayer;
    }

    public boolean RegisterAction(String user, String email, String password) throws Exception{
        String toSend = "{\"name\": \"" + user + "\"," +
                "\"email\": \"" + email + "\"," +
                "\"password\": \"" + password + "\"}";
        String responseString = HTTPClient.post("http://localhost:8080/api/users", toSend);

        //print result
        System.out.println(responseString);
        if(responseString.contains("error")){
            return false;
        }
        else{
            return true;
        }
    }
}
