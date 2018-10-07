package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word>words, int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word word = getItem(position);

        TextView miwokView = (TextView) listItem.findViewById(R.id.miwok_text_view);
        miwokView.setText(word.getMiwokTranslation());

        TextView defaultView = (TextView) listItem.findViewById(R.id.default_text_view);
        defaultView.setText(word.getDefaultTranslation());

        ImageView imageView = (ImageView) listItem.findViewById(R.id.image_view);

        if(word.hasImage()){
            imageView.setImageResource(word.getImageResourceId());
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItem.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItem;
    }
}
