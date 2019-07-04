package com.example.nav;



import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;

import static android.media.CamcorderProfile.get;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static String mark1;
    public static String mark2;
    public static String mark3;
    public static String mark4;
    public static String mark5;
    public static String mark6;
    public static String mark7;
    public static String mark8;
    public static String mark9;






    private String[] titles = {"Master Control",
            "ColLoRa ID: 65463",
            "ColLoRa ID: 34553",
            "ColLoRa ID: 23452",
            "ColLoRa ID: 76453",
            "ColLoRa ID: 23412",
            "ColLoRa ID: 72151",
            "ColLoRa ID: 52151",
            "ColLoRa ID: 11823"};

    private String[] details = {"Switch on all markers",
            "Cow 1", "Cow 2",
            "Cow 3", "Cow 4",
            "Cow 5", "Cow 6",
            "Cow 7","Cow 8" };

    private int[] images = { R.drawable.on_status,
            R.drawable.cowhead,
            R.drawable.on_status,
            R.drawable.on_status,
            R.drawable.on_status,
            R.drawable.on_status,
            R.drawable.on_status,
            R.drawable.on_status,
            R.drawable.cow};


    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        int c1, c2, c3, c4, c5, c6, c7, c8, c9 ;
        public ViewHolder(View itemView) {
            super(itemView);


            //itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            final CardView cardView = (CardView) itemView.findViewById(R.id.card_view);










            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(position == 0 ){
                        if(c9 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c9 = 1;
                            mark9 = "1";


                            Log.d("markers", "mark8");

                        } else if (c9 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c9 = 0;
                            mark9 = "0";
                        }
                    }
                    if(position == 1){
                        if(c2 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c2 = 1;
                            mark2 = "1";
                            Log.d("markers", "mark2");

                        } else if (c2 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c2 = 0;
                            mark2 = "0";
                        }
                    }
                    if(position == 2){
                        if(c3 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c3 = 1;
                            mark3 = "1";
                            Log.d("markers", "mark3");

                        } else if (c3 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c3 = 0;
                            mark3 = "0";
                        }
                    }
                    if(position == 3){
                        if(c4 == 0){
                            mark4 = "1";
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c4 = 1;
                            Log.d("markers", "mark4");

                        } else if (c4 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c4 = 0;
                            mark4 = "0";
                        }
                    }
                    if(position == 4){
                        if(c5 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c5 = 1;
                            mark5 = "1";
                            Log.d("markers", "mark5");

                        } else if (c5 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c5 = 0;
                            mark5 = "0";
                        }
                    }
                    if(position == 5){
                        if(c6 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c6 = 1;
                            mark6 = "1";
                            Log.d("markers", "mark6");

                        } else if (c6 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c6 = 0;
                            mark6 = "0";
                        }
                    }
                    if(position == 6){
                        if(c7 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c7 = 1;
                            mark7 = "1";
                            Log.d("markers", "mark7");

                        } else if (c7 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c7 = 0;
                            mark7 = "0";
                        }
                    }
                    if(position == 7){
                        if(c8 == 0){
                            cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                            c8 = 1;
                            mark8 = "1";
                            Log.d("markers", "mark8");

                        } else if (c8 == 1){

                            cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                            c8 = 0;
                            mark8 = "0";

                        }
                    }
                    if(position == 8){if(c1 == 0 ){

                        cardView.setCardBackgroundColor(Color.rgb(67, 226, 109));
                        c1 = 1;
                        mark1 = "1";

                        Log.d("markers", "mark1");
                    } else if (c1 == 1){

                        cardView.setCardBackgroundColor(Color.rgb(160, 160, 160));
                        c1 = 0;
                        mark1 = "0";
                    }

                    }

                }
            });

        }

       
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        //viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    @Override
    public long getItemId (int position){
        return (position);
    }

}