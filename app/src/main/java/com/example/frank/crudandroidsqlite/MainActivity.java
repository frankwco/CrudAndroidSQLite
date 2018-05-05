package com.example.frank.crudandroidsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.frank.crudandroidsqlite.banco.DAOLancamentos;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Lancamento lancamento = new Lancamento();
//        lancamento.setDescricao("Teste");
//        lancamento.setValorLancamento(10.);
//        lancamento.setTipoLancamento("Credito");
//        new DAOLancamentos(this).inserir(lancamento);//
//        Log.i("MainActivity",String.valueOf(new DAOLancamentos(this).consultar().size()));
        List<Lancamento> listaLancamentos = new DAOLancamentos(this).consultar();

        ListView listView = findViewById(R.id.listaLancamentos);
        AdapterLancamento adapterLancamento = new AdapterLancamento(this, listaLancamentos);
        listView.setAdapter(adapterLancamento);
    }

    public void chamarTelaCadastrar(View view){
        Intent intent = new Intent(this, TelaCadastrarAlterarLancamento.class);
        startActivity(intent);
    }
}
