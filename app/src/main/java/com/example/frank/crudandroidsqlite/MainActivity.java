package com.example.frank.crudandroidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.frank.crudandroidsqlite.banco.DAOLancamentos;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lancamento lancamento = new Lancamento();
        lancamento.setDescricao("Teste");
        lancamento.setValorLancamento(10.);
        lancamento.setTipoLancamento("Credito");
        new DAOLancamentos(this).inserir(lancamento);

        Log.i("MainActivity",String.valueOf(new DAOLancamentos(this).consultar().size()));
    }
}
