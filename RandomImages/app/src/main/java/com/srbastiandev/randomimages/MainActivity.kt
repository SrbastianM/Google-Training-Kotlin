package com.srbastiandev.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagePic: ImageView = findViewById(R.id.imagePic)
        var imagePicTwo: ImageView = findViewById(R.id.imagePicTwo)
        var btnGetImage: Button = findViewById(R.id.btnGetImage)

        //var model: MainActivityViewModel = MainActivityViewModel()
        var model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        var urlImage: MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer {
            print("Se ejecuta si la URL Genera un cambio")
            Picasso.get().load(it).into(imagePic)
            Picasso.get().load(it).into(imagePicTwo)
        })

        btnGetImage.setOnClickListener {
            model.randomNumbersUrl()
        }
    }
}