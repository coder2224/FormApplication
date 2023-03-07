package com.example.formapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.formapplication.databinding.ActivitySecondBinding
import com.example.formapplication.util.Keys

class SecondActivity : AppCompatActivity() {
    lateinit var fname:String
    lateinit var lname:String
    lateinit var mobileno:String
    lateinit var altmobile:String
    lateinit var email:String
    lateinit var gender:String
    lateinit var hobby1:String
    lateinit var hobby2:String
    lateinit var hobby3:String
    lateinit var hobby4:String
    lateinit var hobby5:String
    lateinit var binding:ViewBinding
    var arrayList=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val bundle = intent.getBundleExtra(Keys.BUNDLEKEY)
        fname = bundle!!.getString(Keys.FIRSTNAME).toString()
        lname = bundle.getString(Keys.LASTNAME).toString()
        mobileno = bundle.getString(Keys.MOBILENUMBER).toString()
        altmobile = bundle.getString(Keys.ALTMOBILENUMBER).toString()
        email = bundle.getString(Keys.Email).toString()
        gender = bundle.getString(Keys.GENDER).toString()
        arrayList = bundle.getStringArrayList(Keys.ARRAYLISTOBJECT) as ArrayList<String>

    }

}