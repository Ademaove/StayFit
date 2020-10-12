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
 * Use the {@link ShopFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        ArrayList<Contents> types_of_shopItems=new ArrayList<Contents>();
        types_of_shopItems.add(new Contents( "Absolution",R.drawable.first));
//        types_of_shopItems.add(new Contents( R.drawable.first,"Absolution"));
//        types_of_shopItems.add(new Contents( R.drawable.sec,"Body Burn"));
//        types_of_shopItems.add(new Contents( R.drawable.thir,"Chair Workout"));
//        types_of_shopItems.add(new Contents(R.drawable.forth, "Back & Sides"));
//        types_of_shopItems.add(new Contents( R.drawable.f,"Booty Builder"));
//        types_of_shopItems.add(new Contents( R.drawable.s, "Couch Workout"));
//        types_of_shopItems.add(new Contents( R.drawable.sev, "Ballet Legs"));
//        types_of_shopItems.add(new Contents( R.drawable.e, "Arms & Shoulders"));
//        types_of_shopItems.add(new Contents( R.drawable.sec,"Whole Body"));
//        types_of_shopItems.add(new Contents(R.drawable.forth, "Strength"));
        //Recycling the list page
//        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(Meditation.this, types_of_exs);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        ContentsAdapter adapter = new ContentsAdapter(getActivity(), types_of_shopItems);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
//        this.setTitle("RadMad Shop");
        return rootView;
    }
}