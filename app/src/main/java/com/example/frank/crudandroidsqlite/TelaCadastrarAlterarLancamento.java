package com.example.frank.crudandroidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.frank.crudandroidsqlite.banco.DAOLancamentos;

public class TelaCadastrarAlterarLancamento extends AppCompatActivity {

    Lancamento lancamento = new Lancamento();
    EditText editTextNome;
    EditText editTextValor;
    RadioButton radioButtonCredito;
    RadioButton radioButtonDebito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_alterar_lancamento);
        editTextNome = (EditText) findViewById(R.id.editNome);
        editTextValor = (EditText) findViewById(R.id.editValor);
        radioButtonCredito = (RadioButton) findViewById(R.id.radioCredito);
        radioButtonDebito = (RadioButton) findViewById(R.id.radioDebito);
    }

    public void inserir(View view){
        lancamento.setDescricao(editTextNome.getText().toString());
        lancamento.setValorLancamento(Double.parseDouble(editTextValor.getText().toString()));
        if(radioButtonDebito.isChecked()){
            lancamento.setTipoLancamento("-");
        }else{
            lancamento.setTipoLancamento("+");
        }
        new DAOLancamentos(this).inserir(lancamento);
    }
}
