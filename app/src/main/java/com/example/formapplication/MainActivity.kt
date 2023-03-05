package com.example.formapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.formapplication.databinding.ActivityMeterialUiBinding

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener{
    private lateinit var  binding:ActivityMeterialUiBinding
    private lateinit var fname:String
    private lateinit var lname:String
    private lateinit var mobileno:String
    private lateinit var altmobileno:String
    private lateinit var email:String
    private lateinit var gender:String
    lateinit var hobbies:String
    var arrayList= arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMeterialUiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnsubmit.setOnClickListener(this)
        binding.rbgroup.setOnCheckedChangeListener(this)

    }

    override fun onClick(v: View?) {
       fname=binding.firstnameinput.editText?.text.toString()


        lname=binding.lastnameinput.editText?.text.toString()
        mobileno=binding.mobilenoinput.editText?.text.toString()
        if (isPhoneNumberValid(mobileno))
            Toast.makeText(this," Number is Valid ",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this," Number is InVelid ",Toast.LENGTH_LONG).show()
        altmobileno=binding.altmobilenoinput.editText?.text.toString()
        email=binding.emailinput.editText?.text.toString()
        if(checkphone(mobileno,altmobileno)){
            " Name :    $fname $lname".also { binding.tvFullname.text = it }
            " Mobile No :  $mobileno".also { binding.tvMobno.text = it }
            " Alternative Mobile No : $altmobileno".also { binding.tvAltno.text = it }
            " E-Mail : $email".also { binding.tvEmail.text = it }
            " Gender : $gender".also { binding.tvGender.text = it }
        }
        else
        {
            Toast.makeText(this," Please Enter Alternative Number Different From Main Number  ",Toast.LENGTH_LONG).show()
            return
        }



    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.rbbtnmale->{
               gender=binding.rbbtnmale.text.toString()
            }

            R.id.rbbtnfemale->{
                gender=binding.rbbtnfemale.text.toString()
            }

            R.id.rbbtncustom->{
                gender=binding.rbbtncustom.text.toString()
            }

        }

    }

}
fun checkphone(m1:String,m2:String): Boolean {
    return m1 != m2
}
fun isPhoneNumberValid(phone_number:String):Boolean{
    val regexPattern="^\\d{10}$"
    return Regex(regexPattern).matches(phone_number)
}
