package com.example.portraitlandscapepresentk2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var adapter: ArrayAdapter<CharSequence>
    lateinit var pictures: IntArray
    lateinit var spinner: Spinner
    lateinit var iv: ImageView
    var curpos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv = findViewById(R.id.picture)
        pictures = intArrayOf(R.drawable.car1, R.drawable.car2, R.drawable.car3)

        adapter = ArrayAdapter.createFromResource(this, R.array.pictures, R.layout.item)
        spinner = findViewById<Spinner>(R.id.spinner_pictures_list)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    fun onChangePictureClick(v: View) {
        curpos = (curpos + 1) % pictures.size
        spinner.setSelection(curpos)
        iv.setImageResource(pictures[curpos])
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //val iv = findViewById<ImageView>(R.id.picture)
        iv.setImageResource(pictures[position])
        curpos = position
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Элемент не выбран", Toast.LENGTH_SHORT ).show()
        //val iv = findViewById<ImageView>(R.id.picture)
        iv.setImageResource(R.drawable.squarecat)
    }
}