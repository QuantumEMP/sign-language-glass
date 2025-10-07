import com.google.genai.Client;
import com.google.genai.types.*;

import java.util.List;

public class basic {
    public static void main(String[] args) throws InterruptedException {

        Client client = Client.builder()
                .apiKey((new api()).getApi_key())
                .build();



        GenerateContentResponse response =
                client.models.generateContent("gemini-2.5-flash", "translate \"hello\" to south african sign language, using this translation create a prompt to create a video of a person that signs \"hello\" in south african sign language", null);

        System.out.println(response.text());

        GenerateVideosOperation operation = client.models.generateVideos("veo-3.0-fast-generate-001", GenerateVideosSource.builder()
                        .prompt(response.text())
                        .build(),
                GenerateVideosConfig.builder()
                        .aspectRatio("16:9")
                        .resolution("720p")
                        .build());

        while (!operation.done().orElse(false)) {
            Thread.sleep(1000);
            operation = client.operations.getVideosOperation(operation, null);
        }

        operation.response()
                .flatMap(GenerateVideosResponse::generatedVideos)
                .stream()
                .flatMap(List::stream)
                .findFirst()
                .ifPresent(video -> client.files.download( video, "video.mp4", null));
    }
}