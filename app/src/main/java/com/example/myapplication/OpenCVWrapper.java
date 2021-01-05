package com.example.myapplication;

import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class OpenCVWrapper {

    static Bitmap detectEdge(Bitmap bitmap) {
        Mat src = new Mat();
        Utils.bitmapToMat(bitmap, src);

        Mat edge = new Mat();
        Imgproc.Canny(src, edge, 50, 150);

        Utils.matToBitmap(edge, bitmap);

        src.release();
        edge.release();

        return bitmap;
    }
}
