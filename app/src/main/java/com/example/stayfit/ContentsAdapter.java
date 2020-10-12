package com.example.stayfit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

//public class YoutubeV extends YouTubeBaseActivity{
//    public YoutubeV(View& listItemView) {
//        final YouTubePlayerView videoView = (YouTubePlayerView) listItemView.findViewById(R.id.video);
//abstract class Adena extends YouTubeBaseActivity {}
//abstract class AlmostCombineImpl extends ArrayAdapter<Contents> {
//}
//abstract class AlmostCombine extends AlmostCombineImpl{
//}
//abstract class FianlCombine extends AlmostCombineImpl{
//}
public class ContentsAdapter extends ArrayAdapter<Contents>{

    /** Resource ID for the background color for this list of words */
//    private int mColorResourceId;

    /**
     * Create a new {@link ContentsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Contents}s to be displayed.
     * @ color ResourceId is the resource ID for the background color for this list of words
     */
    public ContentsAdapter(Context context, ArrayList<Contents> words){
//                           int colorResourceId) {
        super(context, 0, words);

//        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_item, parent, false);
        }

        final Contents currentWord = getItem(position);

        TextView main_Name = (TextView) listItemView.findViewById(R.id.main_name);

        if (currentWord.hasName()) {
            // If an image is available, display the provided image based on the resource ID
            main_Name.setText(currentWord.get_name());            // Make sure the view is visible
            main_Name.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            main_Name.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.get_imgID());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        LinearLayout music=(LinearLayout) listItemView.findViewById(R.id.barForMusic);
        if (currentWord.hasAudio()) {

            music.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            music.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
//        View textContainer = listItemView.findViewById(R.id.text_container); for different colored categories
//        // Find the color that the resource ID maps to
//        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        // Set the background color of the text container View
//        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
