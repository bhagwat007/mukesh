package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Match_Adapter extends RecyclerView.Adapter<Match_Adapter.ViewHolder> {


    private List<RoundMatchList> mroundList;
    private Context mactivity;


    public Match_Adapter(Context context, List<RoundMatchList> roundList) {
        mroundList = roundList;
        mactivity = context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mactivity).inflate(R.layout.matchdata, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Match_Adapter.ViewHolder holder, int position) {
        RoundMatchList roundList = mroundList.get(position);
        String data = mroundList.get(position).getRound();
        String typed = mroundList.get(position).getMtype();
        String formats = mroundList.get(position).getMformat();
        String datestarts= mroundList.get(position).getMdatestart();
        String dataends = mroundList.get(position).getMdateend();
        String note = mroundList.get(position).getMatch_url();

        holder.round.setText(data);
        holder.type.setText(typed);
        holder.format.setText(formats);
        holder.datestart.setText(datestarts);
        holder.dateend.setText(dataends);
        holder.short_note.setText(note);
        holder.round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String Id = roundList.getId();


                Intent intent = new Intent(mactivity, Match_Detail.class);
                intent.putExtra("Id", Id);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                mactivity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mroundList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView round,type ,format,datestart,dateend,short_note;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            round = itemView.findViewById(R.id.runs);
            type = itemView.findViewById(R.id.type);
            format = itemView.findViewById(R.id.format);
            datestart = itemView.findViewById(R.id.datestart);
            dateend = itemView.findViewById(R.id.dateend);
            short_note = itemView.findViewById(R.id.batsmenname);
        }

    }
}





