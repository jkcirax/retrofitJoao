package com.example.exercicio.retrofitjoao.resource;

import com.example.exercicio.retrofitjoao.model.ModelPhotos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicePhoto {

    @GET("/photos")
    Call<List<ModelPhotos>> get();



}
