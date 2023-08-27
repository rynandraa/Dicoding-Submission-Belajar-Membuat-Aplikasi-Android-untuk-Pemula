package com.example.aplikasisederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTour: RecyclerView
    private val list = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTour = findViewById(R.id.rv_tour)
        rvTour.setHasFixedSize(true)

        list.addAll(getListTour())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_list) {
            val intent = Intent(
                this, AboutMe::class.java)
            startActivity (intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListTour(): ArrayList<Tour> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLoc = resources.getStringArray(R.array.data_location)
        val listTour = ArrayList<Tour>()
        for (i in dataName.indices) {
            val tour = Tour(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataLoc[i])
            listTour.add(tour)
        }
        return listTour
    }

    private fun showRecyclerList() {
        rvTour.layoutManager = LinearLayoutManager(this)
        val listTourAdapter = ListTourAdapter(list)
        rvTour.adapter = listTourAdapter
        listTourAdapter.setOnItemClickCallback(object : ListTourAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tour) {
                showSelectedTour(data)
            }
        })
    }

    private fun showSelectedTour(tour: Tour) {
        val intentToDetail = Intent(this@MainActivity, DetailWisata::class.java)
        intentToDetail.putExtra("DATA", tour)
        startActivity(intentToDetail)
    //Toast.makeText(this, "Kamu memilih " + tour.name, Toast.LENGTH_SHORT).show()
        //Toast diganti jadi intent parcelable
        //ambil datanya ada di modul recycle view
    }

}