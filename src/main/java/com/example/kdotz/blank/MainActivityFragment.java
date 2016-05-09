package com.example.kdotz.blank;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private List<String> thingsList = null;
    private ListView thingsListView = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Initialize thingsList with values from string.xml
        thingsList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.things_list)));

        //Initiliaze thingsListView to the ListView from rootView (our fragment)
        thingsListView = (ListView) rootView.findViewById(R.id.list_of_things);

        ArrayAdapter<String> thingsArrayAdapter = new ArrayAdapter<String>(rootView.getContext(),
                android.R.layout.simple_list_item_1, thingsList);

        //Set the ArrayAdapter on the List View
        thingsListView.setAdapter(thingsArrayAdapter);

        //Create a click/tap handler for when someone taps something in the list
        thingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the item from the list
                String item = (String) thingsListView.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), ThingDetailActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);


            }
        });

        return rootView;

    }
}
















































