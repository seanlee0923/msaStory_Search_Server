package com.msastory.search.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Value("${api.key}")
    private String apiKey;

    public String getCharactorInfo(String nickname) {
        String urlString = "https://open.api.nexon.com/maplestory/v1/id?character_name=";
        urlString += URLEncoder.encode(nickname, StandardCharsets.UTF_8);
        String ocid ="";
        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", apiKey);
            
            int responseCode = connection.getResponseCode();

            BufferedReader in;
            if(responseCode == 200) { // 정상 응답시 
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else { // 200 이외의 코드가 반환
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            ocid = in.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return ocid;
    }
}