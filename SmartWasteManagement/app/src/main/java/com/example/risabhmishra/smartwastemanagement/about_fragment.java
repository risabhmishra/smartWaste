package com.example.risabhmishra.smartwastemanagement;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class about_fragment extends Fragment {


    public about_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View v = inflater.inflate(R.layout.fragment_about_fragment, container, false);
        TextView tv = (TextView)v.findViewById(R.id.textView2);
        tv.setTypeface(Typer.set(getContext()).getFont(Font.ROBOTO_REGULAR));
        ImageView logo = (ImageView)v.findViewById(R.id.imageView4);
        Picasso.with(getContext()).load(R.drawable.genlogo).into(logo);

        return v;
    }

}
