package com.example.formapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formapplication.databinding.ActivityMeterialUiBinding
import com.example.formapplication.util.Keys


class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    // Here I Declare Private Variables
    //-------------------------------------------------------------------------------------------------
    private lateinit var  binding:ActivityMeterialUiBinding
    private lateinit var fname:String
    private lateinit var lname:String
    private lateinit var mobileno:String
    private lateinit var altmobno:String
    private lateinit var email:String
    private lateinit var gender:String
    private var arrayList=ArrayList<String>()
    //---------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMeterialUiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnsubmit.setOnClickListener(this)
        binding.rbgroup.setOnCheckedChangeListener(this)
        binding.cb1.setOnCheckedChangeListener(this)
        binding.cb2.setOnCheckedChangeListener(this)
        binding.cb3.setOnCheckedChangeListener(this)
        binding.cb4.setOnCheckedChangeListener(this)
        binding.cb5.setOnCheckedChangeListener(this)


    }
    //--------------------------------------------------------------------------------------------------


    // Here I Use RadioButton Properties
    //---------------------------------------------------------------------------------------------------
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
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
    //---------------------------------------------------------------------------------------------------

    // Here I Use Button Properties
    //-----------------------------------------------------------------------------------------------
    @SuppressLint("SuspiciousIndentation")
    override fun onClick(view: View?) {
        when(view?.id) {

            R.id.btnsubmit -> {

                if (binding.firstnameinput.editText?.text.toString()
                        .isEmpty() && binding.lastnameinput.editText?.text.toString().isEmpty()
                    && binding.mobilenoinput.editText?.text.toString()
                        .isEmpty() && binding.altmobilenoinput.editText?.text.toString().isEmpty()
                    && binding.emailinput.editText?.text.toString().isEmpty()) {
                    Toast.makeText(this, "Please Fill All Field", Toast.LENGTH_LONG).show()
                } else if(binding.firstnameinput.editText?.text.toString().isEmpty()){
                   Toast.makeText(this," Please Enter First Name ",Toast.LENGTH_LONG).show()
                    binding.firstnameinput.requestFocus()
                } else if(binding.lastnameinput.editText?.text.toString().isEmpty()){
                    Toast.makeText(this," Please Enter Last Name ",Toast.LENGTH_LONG).show()
                    binding.lastnameinput.requestFocus()
                } else if(binding.mobilenoinput.editText?.text.toString().isEmpty()){
                    Toast.makeText(this," Please Enter Mobile Number ",Toast.LENGTH_LONG).show()
                    binding.mobilenoinput.requestFocus()
                } else if(binding.altmobilenoinput.editText?.text.toString().isEmpty()){
                    Toast.makeText(this," Please Enter Alternative Mobile Number ",Toast.LENGTH_LONG).show()
                    binding.altmobilenoinput.requestFocus()
                } else if(binding.emailinput.editText?.text.toString().isEmpty()){
                    Toast.makeText(this," Please Enter Email ",Toast.LENGTH_LONG).show()
                    binding.emailinput.requestFocus()
                } else if(checkMobileNumber(binding.mobilenoinput.editText?.text.toString(),binding.altmobilenoinput.editText?.text.toString())){
                    Toast.makeText(this," Please Enter Alternative Number Different ",Toast.LENGTH_LONG).show()
                } else{
                    fname=binding.firstnameinput.editText?.text.toString()
                    lname=binding.lastnameinput.editText?.text.toString()
                    mobileno=binding.mobilenoinput.editText?.text.toString()
                    altmobno=binding.altmobilenoinput.editText?.text.toString()
                    email=binding.emailinput.editText?.text.toString()

                    val intent=Intent(this,SecondActivity::class.java)
                    val bundle=Bundle()
                    bundle.putString(Keys.FIRSTNAME,fname)
                    bundle.putString(Keys.LASTNAME,lname)
                    bundle.putString(Keys.MOBILENUMBER,mobileno)
                    bundle.putString(Keys.ALTMOBILENUMBER,altmobno)
                    bundle.putString(Keys.Email,email)
                    bundle.putString(Keys.GENDER,gender)
                    bundle.putStringArrayList(Keys.ARRAYLISTOBJECT,arrayList)
                    intent.putExtra(Keys.BUNDLEKEY,bundle)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkMobileNumber(mobileno: String, altmobileno: String):Boolean {
        return mobileno==altmobileno

    }

    //-----------------------------------------------------------------------------------------------




    //  Here i  Will Use CheckBox Property
    //------------------------------------------------------------------------------------------------
    override fun onCheckedChanged(view: CompoundButton?, isCheked: Boolean) {
            when(view?.id){
                R.id.cb1 ->{
                    if(binding.cb1.isChecked){
                        arrayList.add(binding.cb1.text.toString())

                    }
                    else
                    {
                        arrayList.remove(binding.cb1.text.toString())
                    }

                }
                R.id.cb2 ->{
                    if(binding.cb2.isChecked){
                        arrayList.add(binding.cb2.text.toString())

                    }
                    else
                    {
                        arrayList.remove(binding.cb2.text.toString())

                    }

                }
                R.id.cb3 ->{
                    if(binding.cb3.isChecked){
                        arrayList.add(binding.cb3.text.toString())

                    }
                    else
                    {
                        arrayList.remove(binding.cb3.text.toString())

                    }

                }
                R.id.cb4 ->{
                    if (binding.cb4.isChecked) {
                        arrayList.add(binding.cb4.text.toString())

                    } else {
                        arrayList.remove(binding.cb4.text.toString())


                    }

                }
                R.id.cb5 ->{
                    if(binding.cb5.isChecked){
                        arrayList.add(binding.cb5.text.toString())

                    }
                    else
                    {
                        arrayList.remove(binding.cb5.text.toString())

                    }

                }
            }
    }
    //------------------------------------------------------------------------------------------------------------
    }








