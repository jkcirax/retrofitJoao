package com.example.exercicio.retrofitjoao.activities;

import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.exercicio.retrofitjoao.R;
import com.example.exercicio.retrofitjoao.bootstrap.APIClient;
import com.example.exercicio.retrofitjoao.model.ModelPost;
import com.example.exercicio.retrofitjoao.model.ModelPostAdapter;
import com.example.exercicio.retrofitjoao.resource.ServicoPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServicePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_post);


        //Pega a referencia do ENDPOIT e dp converter(gson)
        Retrofit retrofit = APIClient.getClient();

        //faz o 'bind' da instancia do retrofit com interface, que contém as operações (GET,POST,PUT,DELETE)
        ServicoPost servicoPost = retrofit.create(ServicoPost.class);


        //Faz a chamada do serviço
       Call<List<ModelPost>> get = servicoPost.get();




        get.enqueue(new Callback<List<ModelPost>>() {

            @Override
            public void onResponse(Call<List<ModelPost>> call, Response<List<ModelPost>> response) {
                List<ModelPost> posts = response.body();
                ArrayList<String> elementos = new ArrayList<>();
                if(posts == null){
                    System.out.println("ArrayESTA NULL");

                }else {
                    for (int i = 0; i < posts.size(); i++) {
                        elementos.add(posts.get(i).toString());
                    }
                    if (elementos.isEmpty()) {
                        System.out.print("Esta vazia");
                    } else {
                        System.out.println("Não est vazia");
                    }

                }
                ChamadaComponete(posts);

            }
            @Override
            public void onFailure(Call<List<ModelPost>> call, Throwable t) {
                //se houver algum erro passará por aqui para tratar!!
            }
        });


    }

    private void ChamadaComponete(List<ModelPost> variavel) {
        ListView lista = (ListView) findViewById(R.id.ListView);
        ModelPostAdapter adapter = new ModelPostAdapter(variavel, this);
        lista.setAdapter(adapter);

    }



    }

