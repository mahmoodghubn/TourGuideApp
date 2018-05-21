package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

/**
 * {@link ItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Item} objects.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    static class view {
        TextView songName;
        TextView singerName;
        ImageButton runButton;
    }

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param items           is the list of {@link Item}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of items
     */
    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_content, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Item currentItem = getItem(position);

        // Find the TextView in the item_content.xml layout with the ID text.
        TextView mLink = (TextView) listItemView.findViewById(R.id.text);
        // Get the website from the currentItem object and set this text on
        // the item TextView.
        mLink.setText(currentItem.getWebsiteId());

        if (mLink != null) {

            mLink.setMovementMethod(LinkMovementMethod.getInstance());
        }

        // Find the ImageView in the item_content.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        // If an image is available, display the provided image based on the resource ID
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageResourceId());

            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Find the ImageButton in the item_content.xml layout with the ID map.
        ImageButton imageButton = (ImageButton) listItemView.findViewById(R.id.map);
        view viewHolder = new view();

        // Check if an string resource ID is provided for this item or not
        // If an resource is available, display the provided string based on the resource ID
        if (currentItem.hasMap()) {
            imageButton.setImageResource(R.drawable.baseline_place_black_18);

            // Make sure the view is visible
            imageButton.setVisibility(View.VISIBLE);
            viewHolder.runButton = (ImageButton) listItemView.findViewById(R.id.map);
            viewHolder.runButton
                    .setOnClickListener(new TextView.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(getContext().getString(currentItem.getGoogleMap())));
                            getContext().startActivity(intent);
                        }
                    });
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageButton.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View itemContainer = listItemView.findViewById(R.id.item_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        itemContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
