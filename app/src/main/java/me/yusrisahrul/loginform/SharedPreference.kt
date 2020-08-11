package me.yusrisahrul.loginform

import android.content.Context

class SharedPreference(context: Context) {
    val PREFERENCE_NAME = "MyPreference"
    val NAME = "NAME"
    val EMAIL = "EMAIL"
    val PASSWORD = "PASSWORD"
    val PHONE = "PHONE"

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setName(name: String) {
        val editor = preference.edit()
        editor.putString(NAME, name)
        editor.apply()
    }

    fun setEmail(email: String) {
        val editor = preference.edit()
        editor.putString(EMAIL, email)
        editor.apply()
    }

    fun setPassword(password: String) {
        val editor = preference.edit()
        editor.putString(PASSWORD, password)
        editor.apply()
    }

    fun setPhone(phone: String) {
        val editor = preference.edit()
        editor.putString(PHONE, phone)
        editor.apply()
    }

    fun getEmail() : String? {
        return preference.getString(EMAIL, "")
    }

    fun getPassword(): String? {
        return preference.getString(PASSWORD, "")
    }


}