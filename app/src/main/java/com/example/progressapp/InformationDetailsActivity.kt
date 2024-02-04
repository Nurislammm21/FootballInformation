package com.example.progressapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toolbar
import com.example.progressapp.data.Information
import com.example.progressapp.databinding.ActivityInformationDetailsBinding
import com.google.android.material.appbar.MaterialToolbar

class InformationDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationDetailsBinding
    private lateinit var informational: Information
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Football Club"
        }

       //  informational = intent.getSerializableExtra("information") as? Information

        val selectedInformationID = intent.getStringExtra("informationID")
        informational = MainActivity.infoList.find {
            it.id == selectedInformationID
        }?: Information(
            title = "404 FORBIDDEN",
            description = "Something get wrong repeat after 5 minutes")

        binding.apply {
            teamHeaderImageView.setImageResource(informational.headerImageIdResource)
            txtTitle.text = informational.title
            descriptionTxt.text = informational.description
            longDescriptionTxt.text = informational.descriptionLong

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                finish()
                true
            }
            R.id.menuItemLink ->{
               val intent = Intent(Intent.ACTION_VIEW, Uri.parse(informational.teamUrl))
                startActivity(intent)
                true
            }

            R.id.menuItemFavorite ->{
                    val isCurrentlyFavorite = informational.isFavorite
                    if(isCurrentlyFavorite){
                        item.setIcon(R.drawable.ic_favorite)
                    }else{
                        item.setIcon(R.drawable.ic_favorite_filled)
                    }


                informational.isFavorite =! isCurrentlyFavorite
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_information,menu)

        if(informational.isFavorite){
            menu?.findItem(R.id.menuItemFavorite)?.setIcon(R.drawable.ic_favorite_filled)
        }

        return true

    }
}