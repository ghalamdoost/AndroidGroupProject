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

    ImageView imageView1, imageView2, imageView3, imageView4;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView4 = view.findViewById(R.id.imageView4);


        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-a.jpg?alt=media&token=8872f39e-2564-4041-851d-7f2541631ecd")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView1);

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-b.jpg?alt=media&token=8d23b03a-51bd-47ba-8ba1-93d6971906c3")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView2);

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-c.jpg?alt=media&token=00fd1edd-72dd-4678-a50d-58944e1c264d")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView3);

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/groupproject-b4db1.appspot.com/o/slide-d.jpg?alt=media&token=b02cc6bc-544e-4ae5-8ff3-00a76ce53ecd")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView4);

        return view;
    }


    public void update(View view) {

    }


}
