package com.example.exercicio.retrofitjoao.model;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.exercicio.retrofitjoao.R;

import java.util.List;

public class ModelPostAdapter extends BaseAdapter{

    private final List<ModelPost> lista;
    private final Activity act;

    public ModelPostAdapter(List<ModelPost> lista, Activity act) {
        this.lista = lista;
        this.act = act;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View View, ViewGroup parent){

        View view = act.getLayoutInflater().inflate(R.layout.itens,parent,false);


        ModelPost post = lista.get(position);

        //pegando as referencias das views

        TextView userId = (TextView) view.findViewById(R.id.textuserid);
        TextView id = (TextView) view.findViewById(R.id.textId);
        TextView titulo = (TextView) view.findViewById(R.id.textTitulo);
        TextView complemento = (TextView) view.findViewById(R.id.textComplemento);

        //pulando as views

        //System.out.println("Esta null");

        //  System.out.println("Posição: " + post.getUserId());
        System.out.println(lista.size());
        System.out.println("PRIMEIRO: " );
        userId.setText("UserId: " +post.getUserId());
        id.setText("ID: "+post.getId());
        titulo.setText("Titulo: "+post.getTitle());
        complemento.setText("Complemento: " +post.getBody());


        if(position % 2 == 0){
            view.setBackgroundColor(Color.BLUE);
        }

        return view;
    }


}
