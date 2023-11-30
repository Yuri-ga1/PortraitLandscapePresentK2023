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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO: заменять картинку на ту, которую установили при нажатии кнопки
        // иначе будет исходная с котиком

        //adapter = ArrayAdapter()
        adapter = ArrayAdapter.createFromResource(this, R.array.pictures, R.layout.item)
        val spinner = findViewById<Spinner>(R.id.pictures_list)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)

        // TODO: картинку менять по очереди на следущую
        iv.setImageResource(R.drawable.car1)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "выбран элемент $position", Toast.LENGTH_SHORT ).show()
        // TODO: заменить картинку в зависимости от выбора пользователя
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "не выбран элемент", Toast.LENGTH_SHORT ).show()
    }
}