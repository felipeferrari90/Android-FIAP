package br.com.fiap.aboutme

import android.app.Activity
import android.widget.Toast

fun Activity.toast(msg:String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}