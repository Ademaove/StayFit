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
 * Use the {@link JournalFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class JournalFragment extends Fragment {

    /** Handles playback of all the sound files */

    public JournalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        ArrayList<Contents> types_of_journals=new ArrayList<Contents>();

        types_of_journals.add(new Contents( "RADMAD WELLNESS ISSUE #1", R.drawable.jou1, true));
        types_of_journals.add(new Contents( "RADMAD WELLNESS ISSUE #2", R.drawable.jou3, true));
        types_of_journals.add(new Contents( "RADMAD WELLNESS ISSUE #3", R.drawable.jou2, true));
        types_of_journals.add(new Contents( "RADMAD WELLNESS ISSUE #4", R.drawable.jou1, true));
        types_of_journals.add(new Contents( "RADMAD WELLNESS ISSUE #5", R.drawable.jou3, true));

        //Recycling the list page
//        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(Meditation.this, types_of_exs);

        ContentsAdapter adapter = new ContentsAdapter(getActivity(), types_of_journals);


        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);


        return rootView;
    }

}