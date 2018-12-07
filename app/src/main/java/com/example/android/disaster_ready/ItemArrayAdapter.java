package com.example.android.disaster_ready;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemArrayAdapter extends ArrayAdapter<Item>
{
    private Context mContext;
    int mResource;

    public ItemArrayAdapter(Context context, int resource,  ArrayList<Item> items)
    {
        super(context, 0, items);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        String description = getItem(position).getDescription();

        //this value is not currently used
        //int quantity = getItem(position).getQuantity();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvDescription = convertView.findViewById(R.id.textView1);
        tvDescription.setText(description);

        return convertView;
    }
}
