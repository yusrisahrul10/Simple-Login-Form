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
import id.rizmaulana.sheenvalidator.lib.SheenValidator
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var preference : SharedPreference

    private lateinit var sheenValidator: SheenValidator



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preference = SharedPreference(this)
        sheenValidator = SheenValidator(this)

        sheenValidator.registerAsEmail(editTextLoginPersonEmail)
        sheenValidator.registerAsRequired(editTextLoginPersonEmail)
        sheenValidator.registerAsRequired(editTextLoginPassword)

        sheenValidator.setOnValidatorListener {
            if (editTextLoginPersonEmail.text.toString() == preference.getEmail()
                && editTextLoginPassword.text.toString() == preference.getPassword()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                finishAffinity()
            } else {
                Toast.makeText(this, "Email or Password Wrong!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonLogin.setOnClickListener {
            sheenValidator.validate()
        }

        registerClick()

    }

    private fun registerClick() {
        val text = "Don't have an account? Create One."
        val ss = SpannableString(text)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = object : Intent(this@LoginActivity, RegisterActivity::class.java){

                }

                finishAffinity()
                startActivity(intent)
            }
        }
        ss.setSpan(clickableSpan, 23, 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textViewRegister.text = ss
        textViewRegister.movementMethod = LinkMovementMethod.getInstance()
    }
}