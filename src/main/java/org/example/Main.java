package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

class CatImageFetcher {
    public static void main(String[] args) {
        try {
            // Make GET request to the Cat API
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/images/search")
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            // Parse JSON response using GSON
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(responseBody).getAsJsonArray().get(0).getAsJsonObject();
            String imageUrl = jsonObject.get("url").getAsString();

            // Download and save the image using FileUtils
            byte[] imageBytes = client.newCall(new Request.Builder().url(imageUrl).build()).execute().body().bytes();
            File imageFile = new File("cat_image.jpg");
            FileUtils.writeByteArrayToFile(imageFile, imageBytes);

            System.out.println("Random cat image saved to: " + imageFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
