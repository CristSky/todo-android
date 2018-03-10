package com.cristsky.todo;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TarefaModelo> list = new ArrayList<>();

    public TarefaAdapter(List<TarefaModelo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TarefaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_tarefa, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TarefaModelo tarefaModelo = list.get(position);
        TarefaViewHolder vh = (TarefaViewHolder) holder;
        vh.edtItem.setText(tarefaModelo.getDescricao());
        vh.chkExecutado.setChecked(tarefaModelo.isExecutado());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TarefaViewHolder extends RecyclerView.ViewHolder {
        private CheckBox chkExecutado;
        private TextView edtItem;

        public TarefaViewHolder (View view) {
            super(view);

            chkExecutado = view.findViewById(R.id.chkExecutado);
            edtItem = view.findViewById(R.id.edtItem);
        }
    }
}
