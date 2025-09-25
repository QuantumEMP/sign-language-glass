//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.speech.RecognitionListener;
//import android.speech.RecognizerIntent;
//import android.speech.SpeechRecognizer;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import java.util.ArrayList;
//import java.util.Locale;
//
//public class SpeechToText extends AppCompatActivity {
//
//    private SpeechRecognizer speechRecognizer;
//    private TextView resultTextView;
//    private Button startButton;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        resultTextView = findViewById(R.id.resultTextView);
//        startButton = findViewById(R.id.startButton);
//
//        // Request audio permission if not granted
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.RECORD_AUDIO}, 1);
//        }
//
//        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
//
//        // Set up Recognition Listener
//        speechRecognizer.setRecognitionListener(new RecognitionListener() {
//            @Override public void onReadyForSpeech(Bundle params) {}
//            @Override public void onBeginningOfSpeech() {}
//            @Override public void onRmsChanged(float rmsdB) {}
//            @Override public void onBufferReceived(byte[] buffer) {}
//            @Override public void onEndOfSpeech() {}
//            @Override public void onError(int error) {
//                resultTextView.setText("Error: " + error);
//            }
//
//            @Override
//            public void onResults(Bundle results) {
//                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
//                if (matches != null && !matches.isEmpty()) {
//                    String text = matches.get(0);
//                    resultTextView.setText(text); // display transcribed text
//                }
//            }
//
//            @Override public void onPartialResults(Bundle partialResults) {}
//            @Override public void onEvent(int eventType, Bundle params) {}
//        });
//
//        // Start listening on button click
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//                speechRecognizer.startListening(intent);
//            }
//        });
//    }
//
//    public void getResultTextView() {
//        System.out.println(resultTextView);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (speechRecognizer != null) {
//            speechRecognizer.destroy();
//        }
//    }
//}

