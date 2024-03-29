package com.example.progressapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progressapp.adapters.InformationAdapter
import com.example.progressapp.data.Information
import com.example.progressapp.data.InformationInterface
import com.example.progressapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), InformationInterface  {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: InformationAdapter
     companion object{
         lateinit var infoList : ArrayList<Information>
     }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        infoList = getInformationList()
        adapter = InformationAdapter(infoList,this)
        binding.rcView.adapter = adapter
        binding.rcView.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
        setSupportActionBar(binding.toolbarActivity)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Football Teams"
        }

    }

    private fun getInformationList(): ArrayList<Information>{
        return  ArrayList<Information>().apply {
            add(
                Information(
                    id = "Real Madrid",
                    title = "Real Madrid",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.realmadrid,
                    headerImageUrl = "https://i.pinimg.com/originals/46/01/54/46015466f7484ed7628049f62c2db2cd.jpg",
                    teamUrl = "https://madridistas.com/en-US/madridistas/landing"

                )
            )
            add(
                Information(
                    id = "Barcelona",
                    title = "Barcelona ",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.barcelona,
                    headerImageUrl = "https://64.media.tumblr.com/67ca559f9f8bf6b5d5ac85191af4e107/tumblr_od5gdwuxBR1ude0uno1_500h.jpg",
                    teamUrl = "https://www.fcbarcelona.com/en/"

                )
            )

            add(
                Information(
                    id = "Tottenham",
                    title = "Tottenham",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.tottenham,
                    headerImageUrl = "https://i.pinimg.com/originals/a5/91/3b/a5913b877183e02ab86b2d59708c565a.jpg",
                    teamUrl = "https://www.tottenhamhotspur.com/"

                )
            )


            add(
                Information(
                    id = "FC Bayern",
                    title = "FC Bayern",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.bayern,
                    headerImageUrl = "https://64.media.tumblr.com/0ee98a3a44475b685fb8b42716e01b04/tumblr_od5g941hwm1ude0uno1_500h.jpg",
                    teamUrl = "https://fcbayern.com/en"

                )
            )

            add(
                Information(
                    id = "LiverPool",
                    title = "LiverPool",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.liverpool,
                    headerImageUrl = "https://pbs.twimg.com/media/CrVea3NVMAAEhKn?format=jpg&name=4096x4096",
                    teamUrl = "https://www.liverpoolfc.com/"

                )
            )


            add(
                Information(
                    id = "Chelsea",
                    title = "Chelsea",
                    description = "Description of the club",
                    descriptionLong = "A longer description that is will not be only one line it will takes more",
                    buttonText = "Learn more",
                    headerImageIdResource = R.drawable.chelsea,
                    headerImageUrl = "https://i.pinimg.com/originals/66/2b/ea/662beac3242f10215dc5e826919b3fb3.jpg",
                    teamUrl = "https://www.chelsea.com/"

                )
            )
        }
    }

    override fun onLearnMoreButton(position: Int) {
        val information = infoList[position]
           val intent = Intent(this,InformationDetailsActivity::class.java).apply {
                    putExtra("informationID",information.id)
           }
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


// 1 url of real madrid image: https://i.pinimg.com/originals/46/01/54/46015466f7484ed7628049f62c2db2cd.jpg
// 2 url of barcelona image: https://64.media.tumblr.com/67ca559f9f8bf6b5d5ac85191af4e107/tumblr_od5gdwuxBR1ude0uno1_500h.jpg
// 3 url of tottenham image: https://i.pinimg.com/originals/a5/91/3b/a5913b877183e02ab86b2d59708c565a.jpg
// 4 url of bayern image: https://64.media.tumblr.com/0ee98a3a44475b685fb8b42716e01b04/tumblr_od5g941hwm1ude0uno1_500h.jpg
// 5 url of liverpool image: https://pbs.twimg.com/media/CrVea3NVMAAEhKn?format=jpg&name=4096x4096
// 6 url of chelsea image: https://i.pinimg.com/originals/66/2b/ea/662beac3242f10215dc5e826919b3fb3.jpg

//adding a git changes