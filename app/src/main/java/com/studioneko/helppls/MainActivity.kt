package com.studioneko.helppls

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studioneko.helppls.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var items: MutableList<RvItem> = mutableListOf<RvItem>()

    private var isSortedName: Boolean = false
    private var isSortedPrice: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        var rvColors: RecyclerView = findViewById(R.id.rvColors)
        rvColors.adapter = ColorsAdapter(items)
        rvColors.layoutManager = LinearLayoutManager(this)

        btnInsert.setOnClickListener(){
            items.add(RvItem(editName.text.toString(), editPrice.text.toString() + " Kc"))
            rvColors.adapter?.notifyItemInserted(   items.size - 1)
        }

        btnName.setOnClickListener(){
            isSortedPrice = false

            if(!isSortedName) {
                items.sortBy { it.nameText }
                rvColors.adapter?.notifyDataSetChanged()
                isSortedName = true
            } else {
                items.sortByDescending { it.nameText }
                rvColors.adapter?.notifyDataSetChanged()
                isSortedName = false
            }
        }

        btnPrice.setOnClickListener(){
            isSortedName = false

            if(!isSortedPrice) {
                items.sortBy { it.priceText.substring(0, it.priceText.length - 3).toInt() }
                rvColors.adapter?.notifyDataSetChanged()
                isSortedPrice = true
            } else {
                items.sortByDescending { it.priceText.substring(0, it.priceText.length - 3).toInt() }
                rvColors.adapter?.notifyDataSetChanged()
                isSortedPrice = false
            }
        }
    }
}