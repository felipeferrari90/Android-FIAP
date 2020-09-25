package br.com.fiap.aboutme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //o metodo findByid só funciona depois que o metodo oncreated for feito
    //se vc chama ele antes da um NUllPointerException
    //entao usamos lateinit pra dizer que iremos inicializar a variavel, mas só mais tarde
    //(pra evitar criar um nullable do componente abaixo)

    lateinit var button: Button
    lateinit var buttonEditar:Button
    lateinit var editTextProfissao: EditText
    lateinit var textViewProfissao: TextView
    lateinit var textViewNome: TextView
    lateinit var textViewBiografia: TextView

    //OBS: LATEINIT TEM QUE SER VAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonProfissao)
        buttonEditar = findViewById(R.id.buttonEditar)
        editTextProfissao = findViewById(R.id.editProfissao)
        textViewProfissao = findViewById(R.id.textViewProfissao)
        textViewNome = findViewById(R.id.textViewNome)
        textViewBiografia = findViewById(R.id.textViewBiografia)

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

        }

//        textViewProfissao.setOnClickListener {
//            button.visibility = View.VISIBLE
//            editTextProfissao.visibility = View.VISIBLE
//        }


        buttonEditar.setOnClickListener {

            //Intent - é um recurso do android que faz a comunicao entre seus próprios sistemas
            //this como args é o contexto da classe, que no caso é a mainActivity
            //o 2args é a tela que vc quer abrir, no caso ela pede a classe da tela a ser aberta

            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)

            //e assim usamos um intent pra abrir uma tela, mas podemos usa-lo para abrir varias outras telas ou outros recursos do systema
        }
    }

    //oncreate - é a primeira interacao de criacao de tela, (chamado uma vez só)
    //onResume é os redesenhos posteriores da nossa tela  (chamado varias vezes depois)
    //onPause - estado dela quando outra tela é chamada, ai quando ela volta, ela chama o onResume

    //por isso recuperarDados nao pode ser chamado no onCreate
    override fun onResume() {
        super.onResume()
        recuperaDados()
    }

    //cria menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //menuinflater - variavel nativa do android que referencia que menu sera criado(no caso o que a gente fez na pasta menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //pegar a opcao do item e tratar se ele for clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // no caso abrira a tela de edit
        when(item.itemId){
            R.id.menu_edit -> {
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
                return true
            }
        }

        return false
    }

    //metodo que cria um sharedpreferences e configura as chaves e associa o valor (se existir) como texto nos elementos
    fun recuperaDados() {
        val sharedPreferences = getSharedPreferences("aboutme", Context.MODE_PRIVATE)

        val nome = sharedPreferences.getString("nome", "")
        val profissao = sharedPreferences.getString("profissao", "")
        val biografia = sharedPreferences.getString("biografia", "")

        textViewNome.text = nome
        textViewProfissao.text = profissao
        textViewBiografia.text = biografia


        //antes os compontentes foram inicializados dentro do bloco oncreate , ao inves de declarar os textviews denovo,
        //declararamos eles fora do bloco oncreate e ficando no escopo da classe mainActivity
    }

}
