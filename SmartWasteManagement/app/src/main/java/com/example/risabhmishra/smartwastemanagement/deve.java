package com.example.risabhmishra.smartwastemanagement;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class deve extends AppCompatActivity {
    ImageView dev,logod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_developers);

        dev = (ImageView)findViewById(R.id.img_dev);
        logod = (ImageView)findViewById(R.id.imageView2);
        Picasso.with(deve.this).load(R.drawable.dev).into(dev);
        Picasso.with(this).load(R.drawable.genlogo).into(logod);
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/risabh-mishra-049618123")));
            }
        });
    }
}
