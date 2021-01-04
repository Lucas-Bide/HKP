package com.hkp.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rowTvModel, rowTvName;
        ImageView rowIvBrand;

        public ViewHolder(View itemView) {
            super(itemView);

            rowTvModel = itemView.findViewById(R.id.rowTvModel);
            rowTvName = itemView.findViewById(R.id.rowTvName);
            rowIvBrand = itemView.findViewById(R.id.rowIvBrand);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(ApplicationClass.people.indexOf((Person) v.getTag()));
                }
            });
        }
    }
    public PersonAdapter(Context context) {
        this.activity = (ItemClicked) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person p = ApplicationClass.people.get(position);
        holder.itemView.setTag(p);
        holder.rowTvModel.setText(p.getModel());
        holder.rowTvName.setText(p.getName());

        switch (p.getBrand())
        {
            case "M":
                holder.rowIvBrand.setImageResource(R.drawable.mercedes);
                break;
            case "V":
                holder.rowIvBrand.setImageResource(R.drawable.volkswagen);
                break;
            default:
                holder.rowIvBrand.setImageResource(R.drawable.nissan);
        }
    }

    @Override
    public int getItemCount() {
        return ApplicationClass.people.size();
    }

}
