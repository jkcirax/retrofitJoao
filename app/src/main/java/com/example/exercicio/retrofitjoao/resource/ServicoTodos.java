package com.example.exercicio.retrofitjoao.resource;

import com.example.exercicio.retrofitjoao.model.ModelTodos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicoTodos {

    @GET("/todos")
    Call<List<ModelTodos>> get();

    @GET("todos/{id}")
    Call<List<ModelTodos>> get (int id);


}
