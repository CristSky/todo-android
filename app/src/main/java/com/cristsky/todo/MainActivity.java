package com.cristsky.todo;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaTarefa;
    private FloatingActionButton fabNovaTarefa;
    private TarefaAdapter adapter;
    private static final int NC_NOVA_TAREFA = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaTarefa = findViewById(R.id.listaTarefa);
        fabNovaTarefa = findViewById(R.id.fabNovaTarefa);
        fabNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NovaTarefaActivity.class);
                startActivityForResult(intent, NC_NOVA_TAREFA);
            }
        });

        inicializaLista();
    }

    private void inicializaLista() {
        List<TarefaModelo> list = new ArrayList<TarefaModelo>();

        TarefaModelo t1 = new TarefaModelo();
        t1.setDescricao("tarefa 1");

        TarefaModelo t2 = new TarefaModelo();
        t2.setDescricao("tarefa 2");

        TarefaModelo t3 = new TarefaModelo();
        t3.setDescricao("tarefa 3");

        list.add(t1);
        list.add(t2);
        list.add(t3);

        adapter = new TarefaAdapter(list);
        LinearLayoutManager lim  = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaTarefa.setLayoutManager(lim);
        listaTarefa.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == NC_NOVA_TAREFA) {
            if (data != null) {
                String novaTarefa = data.getStringExtra(NovaTarefaActivity.CHAVE_NOVA_TAREFA);

                Toast.makeText(this, novaTarefa, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
