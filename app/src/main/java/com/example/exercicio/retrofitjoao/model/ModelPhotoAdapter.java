package com.example.exercicio.retrofitjoao.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exercicio.retrofitjoao.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Callback;

public class ModelPhotoAdapter extends BaseAdapter {
    private final List<ModelPhotos> catalogo;
    private final Activity activity;

    public ModelPhotoAdapter(List<ModelPhotos> catalogo,Activity activity) {
        this.activity = activity;
        this.catalogo = catalogo;
    }


    @Override
    public int getCount() {
        return catalogo.size();
    }

    @Override
    public Object getItem(int position) {
        return catalogo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View visao = activity.getLayoutInflater().inflate(R.layout.todositensphoto, parent, false);

        ModelPhotos photos = catalogo.get(position);


        TextView campo1 = (TextView) view.findViewById(R.id.campo1);
        TextView campo2 = (TextView) view.findViewById(R.id.campo2);
        TextView campo3 = (TextView) view.findViewById(R.id.campo3);
        ImageView url = (ImageView) view.findViewById(R.id.url);
        ImageView thumurl = (ImageView) view.findViewById(R.id.thumid);


        campo1.setText("UserId: " + photos.getAlbumId());
        campo2.setText("Id: " + photos.getId());
        campo3.setText("Titulo: " + photos.getTitle());


        Picasso.with(activity).load(photos.getUrl()).resize(150, 150).into(url);
        Picasso.with(activity).load(photos.getThumbnailUrl()).resize(150, 150).into(thumurl);

return view;
    }
}