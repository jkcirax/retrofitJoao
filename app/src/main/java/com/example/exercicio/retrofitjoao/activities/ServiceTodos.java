package com.example.exercicio.retrofitjoao.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.exercicio.retrofitjoao.R;
import com.example.exercicio.retrofitjoao.bootstrap.APIClient;
import com.example.exercicio.retrofitjoao.model.ModelTodos;
import com.example.exercicio.retrofitjoao.model.ModelTodosAdapter;
import com.example.exercicio.retrofitjoao.resource.ServicoTodos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServiceTodos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_todos);

        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();


        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)
        ServicoTodos todosResource = retrofit.create(ServicoTodos.class);


        //Faz a chamada do serviço
        Call<List<ModelTodos>> get = todosResource.get();


        get.enqueue(new Callback<List<ModelTodos>>() {
            @Override
            public void onResponse(Call<List<ModelTodos>> call, Response<List<ModelTodos>> response) {
                // se deu certo executar este metodo
                List<ModelTodos> todos = response.body();

                ChamadaComponete(todos);
            }

            @Override
            public void onFailure(Call<List<ModelTodos>> call, Throwable t) {

            }
        });





    }


    private void ChamadaComponete(List<ModelTodos> variavel) {
        ListView lista = (ListView) findViewById(R.id.ListViewTodos);

        ModelTodosAdapter adapter = new ModelTodosAdapter(variavel, this);
        lista.setAdapter(adapter);
    }



    }

