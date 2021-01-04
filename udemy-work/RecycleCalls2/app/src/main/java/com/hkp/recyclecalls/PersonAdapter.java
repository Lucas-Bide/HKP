package com.hkp.recyclecalls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    private ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> people) {
        this.people = people;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rowTvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowTvName = itemView.findViewById(R.id.rowTvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));

        holder.rowTvName.setText(people.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
