package com.example.simpletapioponwebhook_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends JavaPlugin {

    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        String apiURL = this.getConfig().getString("webhook");
        String json = "{\"content\":\""+this.getConfig().getString("message")+"\"}";

        try {
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);

            try (DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream())) {
                outputStream.write(json.getBytes("UTF-8"));
                outputStream.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 204) {
              getLogger().info("起動通知を送信しました。");
            } else {
              getLogger().info("エラーが発生しました。レスポンスコード" + responseCode);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            // エラー処理
        }
    }
}
