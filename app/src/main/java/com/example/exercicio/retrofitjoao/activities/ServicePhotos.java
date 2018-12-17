package com.example.exercicio.retrofitjoao.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.exercicio.retrofitjoao.R;
import com.example.exercicio.retrofitjoao.bootstrap.APIClient;
import com.example.exercicio.retrofitjoao.model.ModelPhotoAdapter;
import com.example.exercicio.retrofitjoao.model.ModelPhotos;
import com.example.exercicio.retrofitjoao.resource.ServicePhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServicePhotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_photos);
        Retrofit retrofit = APIClient.getClient();

        ServicePhoto servicePhoto =retrofit.create(ServicePhoto.class);

        Call<List<ModelPhotos>> get = servicePhoto.get();


        get.enqueue(new Callback<List<ModelPhotos>>() {
            @Override
            public void onResponse(Call<List<ModelPhotos>> call, Response<List<ModelPhotos>> response) {
                List<ModelPhotos> fotos = response.body();


                ListView lista = (ListView) findViewById(R.id.listFotos);

                ModelPhotoAdapter adapter = new ModelPhotoAdapter(fotos, this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelPhotos>> call, Throwable t) {

            }
        });




    }

}
