package com.example.exercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Exercicio2LeituraJson {
    String apiUrl = "http://localhost:3000/usuarios";

    public void app(){
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            int resposeCode = con.getResponseCode();
            if (resposeCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONArray usuarios = new JSONArray(content.toString());

                List<Usuario> dadosUsuarios = new ArrayList<>();
                int somaIdades = 0;

                System.out.println("Dados dos Usuários:");

                for (int i = 0; i < usuarios.length(); i++){
                    JSONObject usuario = usuarios.addo(new Usuario(
                        usuario.getInt("id"),
                        usuario.getString("nome"),
                        usuario.getInt("idade"),
                        usuario.getString("cidade")
                    ));

                    somaIdades += usuario.getInt("idade");

                    System.out.println("ID: " + usuario.getInt("id \n") + "Nome: "+ usuario.getString("name \n") + "Idade: " + usuario.getInt("idade \n") + "cidade: " + usuario.getString("string \n"));
                    
                }

                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
