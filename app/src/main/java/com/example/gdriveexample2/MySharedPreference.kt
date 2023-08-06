package com.example.gdriveexample2

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {


    fun instance(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }


    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.folderPath
        get() = getString(FOLDER_PATH, "")
        set(value) {
            editMe {
                it.putString(FOLDER_PATH, value)
            }
        }
}