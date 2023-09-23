package net.flow9.thisiskotlin.myapplication1

import android.content.Context
import net.flow9.thisiskotlin.myapplication1.Constants.PREFS_NAME
import net.flow9.thisiskotlin.myapplication1.Constants.PREF_KEY


object Utils {


    fun saveLastSearch(context: Context, query: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_KEY, query).apply()
    }

    fun getLastSearch(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY, null)
    }
}