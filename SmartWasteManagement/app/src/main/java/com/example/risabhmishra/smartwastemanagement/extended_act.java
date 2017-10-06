package com.example.risabhmishra.smartwastemanagement;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class extended_act extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_extended);
        imageView = (ImageView)findViewById(R.id.img_bin);
        textView = (TextView)findViewById(R.id.textView7);



        myref = FirebaseDatabase.getInstance().getReference();

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pgs = dataSnapshot.child("Distance").getValue().toString();
                float pggs = Float.parseFloat(pgs);
                textView.setText(pgs+"%");
                update(pggs);
                textView.setTextSize(pggs);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }



    private void update(float progressing) {
        if (progressing < 15)
        {
            imageView.setImageResource(R.drawable.bin1);



        }
        else if(progressing>= 15 && progressing<35){
            imageView.setImageResource(R.drawable.transition);
            ((TransitionDrawable)imageView.getDrawable()).startTransition(2000);

        }
        else if (progressing>=35 && progressing<65){
            imageView.setImageResource(R.drawable.trasn);
            ((TransitionDrawable)imageView.getDrawable()).startTransition(2000);

        }
        else if(progressing>= 65 && progressing< 85){
            imageView.setImageResource(R.drawable.trasn1);
            ((TransitionDrawable)imageView.getDrawable()).startTransition(2000);
            android.support.v4.app.NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.logo_final)
                            .setContentTitle("Smart Waste Management Application")
                            .setContentText("Your Bin Is Almost 75% Full");

            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());

        }
        else if(progressing>=85 && progressing<=100){
            imageView.setImageResource(R.drawable.trasn2);
            ((TransitionDrawable)imageView.getDrawable()).startTransition(2000);
            android.support.v4.app.NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.logo_final)
                            .setContentTitle("Smart Waste Management Application")
                            .setContentText("Your Bin Is Almost 100% Full");

            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());

        }

    }

}

