package com.msastory.search.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.domain.OcidData;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {

    @Value("${api.key}")
    private String apiKey;

    private String basicUrl = "https://open.api.nexon.com/maplestory/v1/";
    private String ocid = "";

    ObjectMapper objectMapper = new ObjectMapper();

    OcidData data = new OcidData();

    public String getCharactorInfoBy(String nickname) {
        // log.info(basicUrl+"id?character_name="+URLEncoder.encode(nickname, StandardCharsets.UTF_8));
        ocid = getOcidBy(nickname);
        // log.info(ocid);

        return ocid;
    }


    // 닉네임을 이용하여 캐릭터 식별자(ocid)값을 얻음
    private final String getOcidBy(String nickname) {
        try {
            URL url = new URL(basicUrl+"id?character_name="+URLEncoder.encode(nickname, StandardCharsets.UTF_8));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", apiKey);

            int responseCode = connection.getResponseCode();

            BufferedReader in;
            if(responseCode == 200) { // 정상 응답시 
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else { // 200 이외의 코드가 반환될 시
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            ocid = in.readLine();

            data = objectMapper.readValue(ocid,OcidData.class);

            ocid = data.getOcid();
            log.info("Nickname searched {}",nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ocid;
    }
}