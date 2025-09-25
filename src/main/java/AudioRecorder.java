//import android.media.MediaRecorder;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//import java.io.IOException;
//
//public class AudioRecorder extends AppCompatActivity {
//
//    private MediaRecorder mediaRecorder;
//    private String outputFile;
//    private Button recordButton, stopButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recordButton = findViewById(R.id.record_button);
//        stopButton = findViewById(R.id.stop_button);
//
//        // Set file output path for audio recording
//        outputFile = getExternalFilesDir(null).getAbsolutePath() + "/recorded_audio.3gp";
//
//        recordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startRecording();
//            }
//        });
//
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                stopRecording();
//            }
//        });
//    }
//
//    // Start recording audio
//    private void startRecording() {
//        mediaRecorder = new MediaRecorder();
//        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//        mediaRecorder.setOutputFile(outputFile);
//
//        try {
//            mediaRecorder.prepare();
//            mediaRecorder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Stop the audio recording
//    private void stopRecording() {
//        if (mediaRecorder != null) {
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//        }
//    }
//}
