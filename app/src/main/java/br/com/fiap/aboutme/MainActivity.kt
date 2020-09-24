package br.com.fiap.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


//main gerado automaticamente, é como se fosse nossa screen main
class MainActivity : AppCompatActivity() {

    //metodo sobrescrito criado automaticamente,
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pegando componentes do xml e passando para variaveis
        val button: Button = findViewById(R.id.buttonProfissao)
        val textViewProfissao: TextView = findViewById(R.id.textViewProfissao)
        val editTextProfissao: EditText = findViewById(R.id.editProfissao)


        button.setOnClickListener {

            val profissao = editTextProfissao.text.toString()

            if(profissao.isNotEmpty()) {
                textViewProfissao.text = profissao
                button.visibility = View.GONE
                editTextProfissao.visibility = View.GONE
            }else {
                editTextProfissao.error = "Digite sua profissão"
                toast("Digite sua profissão")
            }

            /*
               .text = pega o conteudo em texto do que esta escrito atualmente no componente
               .error = conteudo do quando ele apontar um erro

               - ao clicar no botao FEITO sera verificado se o conteudo da profissao esta vazio,
               caso esteja vazio nossa funcao toast é executada.
               - se houver conteudo ai o botão simplesmente sumira, e sera gravado no
               conteudo do textView de profissao a nova palavra



            * */


        }

        textViewProfissao.setOnClickListener {
            button.visibility = View.VISIBLE
            editTextProfissao.visibility = View.VISIBLE

            /*

            ao clicar no textview de profissao o botao e o formulario de texto(edittext) ficara
            visivel tambem

            * */
        }



    }
}
