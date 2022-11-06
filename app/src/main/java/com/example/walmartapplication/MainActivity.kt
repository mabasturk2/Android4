package com.example.walmartapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var userList : ArrayList<User> =
        ArrayList(Arrays.asList(User("u1","u1","u1","u1"), User("u2","u2","u2","u2"), User("u3","u3","u3","u3"),User("u4","u4","u4","u4"), User("u5","u5","u5","u5")))

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        addListenerOnSignIn()
        addListenerOnCreateAccount()
    }
    fun addListenerOnSignIn() {
        var email = findViewById<EditText>(R.id.editTextEmail)
        var pswd = findViewById<EditText>(R.id.editTextPassword)
        var buttonSum = findViewById(R.id.signInButton) as Button
        var check= false
        buttonSum.setOnClickListener {
            Log.i("info","clicked")
            for(u in userList) {
                if (u.userName==email.text.toString())
                    if (u.password==pswd.text.toString())
                        check=true
            }
            if (check==true){
                startActivity(Intent(this@MainActivity, CatalogActivity::class.java))
                Log.i("info","login success")
            }
        }
    }
    fun addListenerOnCreateAccount(){
        var button = findViewById(R.id.button2) as Button
        button.setOnClickListener{
            startActivity(Intent(this@MainActivity, CreateAccountActivity::class.java))
        }
    }
}