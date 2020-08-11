package me.yusrisahrul.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var preference : SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        preference = SharedPreference(this)

        val text = "Already have an account? Login."
        val ss = SpannableString(text)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = object : Intent(this@RegisterActivity, LoginActivity::class.java){
                }

                finishAffinity()
                startActivity(intent)
            }
        }
        ss.setSpan(clickableSpan, 25, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textViewLogin.text = ss
        textViewLogin.movementMethod = LinkMovementMethod.getInstance()

        buttonRegister.setOnClickListener {
            preference.setName(editTextRegisterPersonName.text.toString())
            preference.setEmail(editTextRegisterEmailAddress.text.toString())
            preference.setPhone(editTextRegisterPhone.text.toString())
            preference.setPassword(editTextRegisterPassword.text.toString())

            Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}