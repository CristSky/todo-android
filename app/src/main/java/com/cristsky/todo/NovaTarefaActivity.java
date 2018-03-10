package com.cristsky.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NovaTarefaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNovaTarefa;
    private Button btnIncluir;
    public static final String CHAVE_NOVA_TAREFA = "key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_tarefa);

        editNovaTarefa = findViewById(R.id.edtNovaTarefa);
        btnIncluir = findViewById(R.id.btnSave);

        btnIncluir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
//            Toast.makeText(this, "Gaaoooo!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra(CHAVE_NOVA_TAREFA, editNovaTarefa.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}
