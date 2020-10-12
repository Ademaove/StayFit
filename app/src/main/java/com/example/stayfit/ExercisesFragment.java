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
 * Use the {@link ExercisesFragment#} factory method to
 * create an instance of this fragment.
 */
public class ExercisesFragment extends Fragment {

    /** Handles playback of all the sound files */

    public ExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        ArrayList<Contents> types_of_exs=new ArrayList<Contents>();
//        types_of_exs.add(new Contents( "Absolution", R.drawable.firstv));
//        types_of_exs.add(new Contents( "Body Burn", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents("Chair Workout", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents("Back & Sides", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents( "Booty Builder", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents( "Couch Workout", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents(  "Ballet Legs", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents( "Arms & Shoulders", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents("Whole Body", "https://www.youtube.com/watch?v=g5I2437QqXk"));
//        types_of_exs.add(new Contents( "Strength", "https://www.youtube.com/watch?v=g5I2437QqXk"));

        ContentsAdapter adapter = new ContentsAdapter(getActivity(), types_of_exs);

        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);
        // Set a click listener to play the audio when the list item is clicked on

        return rootView;
    }

}