package com.example.risabhmishra.smartwastemanagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class home_fragment extends Fragment {

    private ImageView profile;
    private TextView uname;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.fragment_home_fragment, container,
                false);
        mAuth = FirebaseAuth.getInstance();
        TextView home = (TextView)v.findViewById(R.id.home_txt);
        TextView swipe = (TextView)v.findViewById(R.id.tv_swipe);
        home.setTypeface(Typer.set(getContext()).getFont(Font.ROBOTO_REGULAR));
        swipe.setTypeface(Typer.set(getContext()).getFont(Font.ROBOTO_REGULAR));
profile = (ImageView)v.findViewById(R.id.home_profile);
        uname = (TextView)v.findViewById(R.id.home_name);

        FirebaseUser current = mAuth.getCurrentUser();
        String currentuser = current.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference().child("Users").child(currentuser);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("Name").getValue().toString();
                String image = dataSnapshot.child("Image").getValue().toString();
                Picasso.with(getContext()).load(image).into(profile);
                uname.setText(name);
                uname.setTypeface(Typer.set(getContext()).getFont(Font.ROBOTO_REGULAR));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });


        return v;
    }


}