package pageObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class PropertiesCollection {
    public static WebDriver driver;
    public static String username;// =  "tecforceTask";
    public static String password;// = "tecTask12345";
    public static Map<String, String> result;

    // пример через gson
    @SuppressWarnings("unchecked")
    public static void parseJsonDataLoginPassword() {
        String authPath = "src/test/testData/auth.json";
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(authPath));
            JSONObject jsonObject = (JSONObject) obj;
            username = (String) jsonObject.get("username");
            password = (String) jsonObject.get("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // через jackson
    public static void parsePosts() throws IOException {
        String postsPath = "src/test/testData/posts.json";
        result = new ObjectMapper().readValue(new File(postsPath), new TypeReference<Map<String, String>>() {});
    }

}
