package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 */
public class MyTest {

    @Test
    public void nihao(){
        try {
            URL url = new URL("https://api.aichatos.cloud/api/generateStream");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Origin", "https://chat10.yqcloud.top");
            con.setRequestProperty("Referer", "https://chat10.yqcloud.top/");
            con.setRequestProperty("Referrer-Policy", "strict-origin-when-cross-origin");
            con.setDoOutput(true);
            String message = "Hello, world!"; // Replace with your message
            String jsonInputString = "{\"prompt\":\"" + message + "\",\"userId\":\"#/chat/1685347567167\",\"network\":true,\"system\":\"\",\"withoutContext\":false,\"stream\":false}";
            try (var os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
