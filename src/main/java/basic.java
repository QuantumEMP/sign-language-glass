import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class basic {
    public static void main(String[] args) {
        Client client = Client.builder()
                .apiKey("AIzaSyCV3nyovUpBoa9LY4be-MS42AglxVgyMMM")
                .build();

        GenerateContentResponse response =
                client.models.generateContent("gemini-2.5-flash", "what is \"hello\" in south african sign language", null);

        System.out.println(response.text());
    }
}