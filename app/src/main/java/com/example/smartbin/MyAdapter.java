package com.example.smartbin;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private final List<ListData>listData;
    int value, percentage;
    private Handler handler = new Handler();


    public MyAdapter(List<ListData> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListData ld=listData.get(position);
        value = Integer.parseInt(ld.getLevel());
        percentage = 100 - ((value * 100) / 55);
        if(value <= 5 ){
            holder.txtstatus.setText("Please collect the wastage");
            holder.progressBar.setProgress(percentage);

        }
        else if(value <= 65 && value >= 5 ) {
            holder.txtstatus.setText("Ready for use");
            holder.progressBar.setProgress(percentage);
        }
        else {
            holder.txtstatus.setText("Wait for Response");
            holder.progressBar.setProgress(percentage);
        }

        holder.txtid.setText("Id : " + ld.getId());
        holder.txtdate.setText("Date : " + ld.getDate());
        holder.txttime.setText("Time : " + ld.getTime());
        holder.txtvalue.setText("Level : " + ld.getLevel() + " cm");
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setOnItemClickListener(MainActivity mainActivity) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid,txtdate,txttime,txtvalue,txtstatus;
        private ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            txtid=(TextView)itemView.findViewById(R.id.idtxt);
            txtdate=(TextView)itemView.findViewById(R.id.datetxt);
            txttime=(TextView)itemView.findViewById(R.id.timetxt);
            txtvalue=(TextView)itemView.findViewById(R.id.valuetxt);
            txtstatus=(TextView)itemView.findViewById(R.id.statustxt);
            progressBar = itemView.findViewById(R.id.levelProgressBar);
        }
    }
}