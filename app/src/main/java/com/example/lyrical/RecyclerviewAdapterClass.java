package com.example.lyrical;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapterClass extends RecyclerView.Adapter<RecyclerviewAdapterClass.myViewHolder> {

    //This class is a standard adapter for my recyclerview, which i use to show all the definitions that the API returns
    Context context;
    List<ItemClass> mainlist;

    public RecyclerviewAdapterClass(Context context, List<ItemClass> mainlist) {
        Log.e("Tag", mainlist.toString());
        this.context = context;
        this.mainlist = mainlist;
    }


    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater maininflater = LayoutInflater.from(context);
        View mainview = maininflater.inflate(R.layout.definition_card, parent, false);
        return new myViewHolder(mainview);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.txword.setText(mainlist.get(position).getTxword());
        holder.txexplanation.setText(mainlist.get(position).getTxexplanation());
        holder.txexample.setText(mainlist.get(position).getTxexample());
        holder.txbyline.setText(mainlist.get(position).getTxbyline());
        holder.txlikes.setText(mainlist.get(position).getTxlikes());
        holder.txdislikes.setText(mainlist.get(position).getTxdislikes());

    }

    @Override
    public int getItemCount() {
        return mainlist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView txword;
        TextView txexplanation;
        TextView txexample;
        TextView txbyline;
        TextView txlikes;
        TextView txdislikes;
        
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txword = itemView.findViewById(R.id.txword);
            txexplanation = itemView.findViewById(R.id.txexplanation);
            txexample = itemView.findViewById(R.id.txexample);
            txbyline = itemView.findViewById(R.id.txbyline);
            txlikes = itemView.findViewById(R.id.txlikes);
            txdislikes = itemView.findViewById(R.id.txdislikes);

        }
    }

}
