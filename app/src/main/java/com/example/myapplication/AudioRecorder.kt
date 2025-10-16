package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log

class AudioRecorder(private val context: Context) {

    private var speechRecognizer: SpeechRecognizer? = null
    private var recognitionListener: RecognitionListener? = null

    fun initialize(listener: Any) {
        recognitionListener = listener as RecognitionListener?
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
            speechRecognizer?.setRecognitionListener(recognitionListener)
        } else {
            // Handle device that doesn't support speech recognition
            Log.e("MySpeechRecorder", "Speech recognition not available")
        }
    }

    fun startListening(intent: Intent) {
        speechRecognizer?.startListening(intent)
    }

    fun stopListening() {
        speechRecognizer?.stopListening()
    }

    fun destroy() {
        speechRecognizer?.destroy()
        speechRecognizer = null
    }
}
