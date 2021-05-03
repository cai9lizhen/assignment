package com.example.assignment

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.module.AppGlideModule
import com.example.assignment.GlideOptions.bitmapTransform
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation

@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val multi = MultiTransformation<Bitmap>(
                BlurTransformation(25),
                RoundedCornersTransformation(128, 0, RoundedCornersTransformation.CornerType.ALL),
                ColorFilterTransformation(Color.argb(80, 0, 0, 255)),
                        SwirlFilterTransformation(0.5f, 1.0f, PointF(0.5f, 0.5f))
        )


        val img : ImageView = findViewById(R.id.orange)
        GlideApp.with(this)
                .load(R.drawable.orange)
                .apply(bitmapTransform(multi))
                .into(img)
    }
}