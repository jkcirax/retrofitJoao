package com.example.exercicio.retrofitjoao.resource;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FormDados {

    @POST("posts")
    Call <POST> creatPost(@Body POST post);
}
