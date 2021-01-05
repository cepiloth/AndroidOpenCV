package com.example.myapplication

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        findViewById<TextView>(R.id.sample_text).text = stringFromJNI()
        val imageView = ImageView(this);
        imageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                imageView.isDrawingCacheEnabled = true;
                imageView.buildDrawingCache();
                val bitmap:Bitmap = Bitmap.createBitmap(imageView.drawingCache);
                val result: (Bitmap?) -> Bitmap = { bitmap: Bitmap? -> OpenCVWrapper.detectEdge(bitmap) };

                Log.d("MainActivity", "OpenCV is loaded successfully!");
            }
        })
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")

            if(OpenCVLoader.initDebug()) {
                Log.d("MainActivity", "OpenCV is loaded successfully!");
            }
            else {
                Log.d("MainActivity", "OpenCV is not loaded!");
            }
        }
    }
}