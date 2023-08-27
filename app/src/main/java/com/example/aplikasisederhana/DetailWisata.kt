package com.example.aplikasisederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailWisata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = "Detail"
        val data = intent.getParcelableExtra<Tour>("DATA")
        println(data?.name.toString())
        var img : ImageView=findViewById(R.id.image_wisata)
        var wst : TextView=findViewById(R.id.nama_wisata)
        var loc : TextView=findViewById(R.id.lokasi)
        var desc : TextView=findViewById(R.id.desc_wisata)

        img.setImageResource(data?.photo!!)
        wst.text= data.name
        loc.text=data.loc
        desc.text=data.description

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}