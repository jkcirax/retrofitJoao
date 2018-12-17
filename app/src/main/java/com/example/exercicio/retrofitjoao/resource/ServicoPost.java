package com.example.exercicio.retrofitjoao.resource;

import com.example.exercicio.retrofitjoao.model.ModelPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicoPost {

    @GET("/posts")
    Call<List<ModelPost>> get();
}
