package com.example.jlopez.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jlopez.platzigram.R;
import com.example.jlopez.platzigram.adapter.PictureAdapterRecyclerView;
import com.example.jlopez.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("",false, view);

        RecyclerView picturesRecycler = view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);


    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://images.pexels.com/photos/466686/pexels-photo-466686.jpeg?auto=compress&cs=tinysrgb&h=350", "Nicoll Sarai", "2 horas", "48 Me gusta"));
        pictures.add(new Picture("https://images.pexels.com/photos/466684/pexels-photo-466684.jpeg?auto=compress&cs=tinysrgb&h=350", "Carlos Fernández", "1 día", "4 Me gusta"));
        pictures.add(new Picture("https://images.pexels.com/photos/466685/pexels-photo-466685.jpeg?auto=compress&cs=tinysrgb&h=350", "Nicoll Sarai", "2 semanas", "8 Me gusta"));
        pictures.add(new Picture("https://images.pexels.com/photos/466685/pexels-photo-466685.jpeg?auto=compress&cs=tinysrgb&h=350", "Fraini Salazar", "20 horas", "21 Me gusta"));
        pictures.add(new Picture("https://images.pexels.com/photos/466685/pexels-photo-466685.jpeg?auto=compress&cs=tinysrgb&h=350", "Erick Rengel", "1 día", "12 Me gusta"));
        pictures.add(new Picture("https://images.pexels.com/photos/466686/pexels-photo-466686.jpeg?auto=compress&cs=tinysrgb&h=350", "Nicoll Sarai", "2 horas", "48 Me gusta"));

        return pictures;
    }


}
