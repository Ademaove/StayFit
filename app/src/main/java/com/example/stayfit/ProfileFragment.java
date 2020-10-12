package com.example.stayfit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        ArrayList<Contents> types_of_exs=new ArrayList<Contents>();
        types_of_exs.add(new Contents( R.drawable.m1));
        types_of_exs.add(new Contents( R.drawable.m2));
        types_of_exs.add(new Contents( R.drawable.m3));
        types_of_exs.add(new Contents(R.drawable.m4));
        types_of_exs.add(new Contents( R.drawable.m5));
        types_of_exs.add(new Contents( R.drawable.m6));
        types_of_exs.add(new Contents( R.drawable.sev));
        types_of_exs.add(new Contents( R.drawable.e));
        types_of_exs.add(new Contents( R.drawable.sec));
        types_of_exs.add(new Contents(R.drawable.forth));
        ContentsAdapter adapter = new ContentsAdapter(getActivity(), types_of_exs);


        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on

        return rootView;
    }
}