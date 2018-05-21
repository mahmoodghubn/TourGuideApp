package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class HistoricalPlacesFragment extends Fragment {
    public HistoricalPlacesFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of items
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.al_hamidiyah_souq, R.string.al_hamidiyah_souq,R.string.al_hamediah_souq_map));
        items.add(new Item(R.drawable.citadel_of_damascus, R.string.citadel_of_damascus,R.string.citadel_of_damascus_map));
        items.add(new Item(R.drawable.umayyad_mosque,R.string.umayyad_mosque,R.string.umayyaed_mosque_map));
        items.add(new Item(R.drawable.tekkiye_mosque,R.string.tekkiye_mosque,R.string.tekkiye_mosque_map));
        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.historical_places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // item_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}

