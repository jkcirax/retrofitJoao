package com.example.exercicio.retrofitjoao.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exercicio.retrofitjoao.R;
import com.example.exercicio.retrofitjoao.resource.FormDados;
import com.example.exercicio.retrofitjoao.resource.ServicePhoto;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    Button button;

    String url = "https://cdn.autopapo.com.br/box/uploads/2017/06/21142944/dodge-demon-lan%C3%A7amento.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(getApplicationContext()).load(url).into(imageView);
            }
        });
    }

    public void ServicoPosts(View view) {
        Intent intent = new Intent(this, ServicePost.class);
        startActivity(intent);
    }


    public void ServicoTodos(View view) {
        Intent intent = new Intent(this,ServiceTodos.class);
        startActivity(intent);
    }

    public void servicePhotos(View view) {
        Intent intent = new Intent(this, ServicePhoto.class);
        startActivity(intent);
    }
}
