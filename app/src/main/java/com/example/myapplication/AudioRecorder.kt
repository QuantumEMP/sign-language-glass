package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.createSpeechRecognizer

class AudioRecorder{
    lateinit var listener: RecognitionListener
    lateinit var speech: SpeechRecognizer

    fun startRecording(applicationContext: Context, intent: Intent) {
        speech = createSpeechRecognizer(applicationContext)
        speech.setRecognitionListener(listener)
        val thread1 = Thread {
            speech.startListening(intent)
        }
        thread1.start()
        Thread.sleep(1000)
    }

}