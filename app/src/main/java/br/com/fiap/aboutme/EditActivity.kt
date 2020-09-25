package br.com.fiap.aboutme

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val sharedPreferences: SharedPreferences = getSharedPreferences("aboutme", Context.MODE_PRIVATE)

        //recuperando os componentes da tela para uma variavel
        val editNome: EditText = findViewById(R.id.editTextNome)
        val editProfissao: EditText = findViewById(R.id.editTextProfissao)
        val editBiografia: EditText = findViewById(R.id.editTextBiografia)
        val buttonSalvar : Button = findViewById(R.id.buttonSalvar)

        //criando atributos (colunas de banco) do sharedpreferenses que ainda nao tem valor
        //e adicionando a uma variavel (caso nenhum valor seja add a ela ela fica com o valor default) ("")
        val nome = sharedPreferences.getString("nome", "")
        val profissao = sharedPreferences.getString("profissao", "")
        val biografia = sharedPreferences.getString("biografia", "")

        //variavel que sera passada como argumento ao elemento,
        //setText - adiciona um texto nos componentes abaixo aonde associara a chave criada acima
        editNome.setText(nome)
        editTextProfissao.setText(profissao)
        editBiografia.setText(biografia)

        buttonSalvar.setOnClickListener {


            //vc atribui o sharedPreferences pra edicao e salva em uma variavel
            //que serve como uma variavel que fara essa edicao
            val editor = sharedPreferences.edit()

            //aqui vc adiciona no campo o texto que esta no campo no atributo configurado antes
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putString("biografia", editBiografia.text.toString())

            //apply - salva as alteracoes no banco(sharedPreferencies)
            editor.apply()
            toast("Dados salvos com sucesso!")

            //fecha a tela do EditActivity e abre a anterior que estava
            finish()

        }

    }
}
