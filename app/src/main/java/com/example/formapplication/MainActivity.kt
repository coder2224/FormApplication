package com.example.formapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formapplication.databinding.ActivityMeterialUiBinding

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var  binding:ActivityMeterialUiBinding
    private lateinit var fname:String
    private lateinit var lname:String
    private lateinit var mobileno:String
    private lateinit var altmobileno:String
    private lateinit var email:String
    private lateinit var gender:String


    //--------------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMeterialUiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnsubmit.setOnClickListener(this)
        binding.rbgroup.setOnCheckedChangeListener(this)


    }

//--------------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------------
    // Here I Use RadioButton Properties
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

// Here I Use Button Properties
    //-----------------------------------------------------------------------------------------------
    @SuppressLint("SuspiciousIndentation")
    override fun onClick(v: View?) {
       fname=binding.firstnameinput.editText?.text.toString()
        lname=binding.lastnameinput.editText?.text.toString()
        mobileno=binding.mobilenoinput.editText?.text.toString()
        altmobileno=binding.altmobilenoinput.editText?.text.toString()
        email=binding.emailinput.editText?.text.toString()

        binding.cb2.setOnCheckedChangeListener(this)
        if(validationOnNumbers(mobileno,altmobileno)) {
            " Name :    $fname $lname".also { binding.tvFullname.text = it }
            " Mobile No :  $mobileno".also { binding.tvMobno.text = it }
            " Alternative Mobile No : $altmobileno".also { binding.tvAltno.text = it }
            " E-Mail : $email".also { binding.tvEmail.text = it }
            " Gender : $gender".also { binding.tvGender.text = it }
        }
    else{
        Toast.makeText(this," Please Enter Alternative Number Different ",Toast.LENGTH_LONG).show()
            return
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        binding.cb1.isChecked
    }

    //-----------------------------------------------------------------------------------------------

    //  Here i  Will Use CheckBox Property
    }
fun validationOnNumbers(m1:String,m2:String):Boolean{
    return m1!=m2
}








