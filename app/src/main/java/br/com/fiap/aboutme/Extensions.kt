package br.com.fiap.aboutme

import android.app.Activity
import android.widget.Toast

//metodo criado pra gerar um toast
fun Activity.toast(msg:String) {

    //acessando o maketext - metodo estatico da classe Toast que gera a msg
    // .show() - mostra a imagem gerada
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}