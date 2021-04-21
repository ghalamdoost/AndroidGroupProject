package com.example.groupproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.storage.FirebaseStorage;

public class SlideShowFragment extends Fragment {

    ImageView imageView1, imageView2, imageView3;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);


        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-a.jpg?alt=media&token=c2e43dae-a8af-4a52-9559-2743fc440480")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView1);

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-b.jpg?alt=media&token=5c44973d-83f7-4057-8334-4ee5afa26464")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView2);

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-c.jpg?alt=media&token=cabd8651-9a86-47e6-a5a5-40d450a06862")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView3);

        return view;
    }


    public void update(View view) {

    }


}
