package com.example.formapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formapplication.databinding.ActivitySecondBinding
import com.example.formapplication.util.Keys

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent=intent
        val bundle=intent.getBundleExtra(Keys.BUNDLEKEY)
        val fname=bundle?.getString(Keys.FIRSTNAME)
        val lname= bundle?.getString(Keys.LASTNAME)
        val mobno= bundle?.getString(Keys.MOBILENUMBER)
        val altmobno=bundle?.getString(Keys.ALTMOBILENUMBER)
        val gender=bundle?.getString(Keys.GENDER)
        val email=bundle?.getString(Keys.Email)
        val  arraylist=bundle?.getStringArrayList(Keys.ARRAYLISTOBJECT)
        val listname=arraylist.toString().replace("[","").replace("]","")
        binding.tvfullname.text=" Name : - $fname $lname"
        binding.tvmob.text=" Mobile No. : - $mobno"
        binding.tvaltmob.text=" Alt-Mobile No. : - $altmobno"
        binding.tvemail.text=" Email : - $email"
        binding.tvgender.text=" Gender : - $gender"
        binding.tvhobbies.text=" Hobbies : - $listname"
    }

}