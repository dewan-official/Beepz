package ds.example.beepz.Views.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ds.example.beepz.Models.ServicesItem;
import ds.example.beepz.R;
import ds.example.beepz.Views.activity.ServiceActivity;
import ds.example.beepz.utils.AppCons;

public class MyServices extends RecyclerView.Adapter<MyServices.ViewHolder> {
    private List<ServicesItem> items;
    private Context context;

    public MyServices(List<ServicesItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.service_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(items.get(position).getCategory().getIcon()).into(holder.icon);
        holder.title.setText(items.get(position).getCategory().getCategoryName());
        holder.car_details.setText("Car Details: "+items.get(position).getCar().getVehicleModel()+" ("+items.get(position).getCar().getVehicleModel().getModelName()+")");
        holder.date.setText("Date of services: "+ AppCons.convertTime(items.get(position).getBookingDate()));
        holder.way.setText(items.get(position).getOrderTrack().getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceActivity.class);
                intent.putExtra("order_id", items.get(position).getOrderId());
                intent.putExtra("position", items.get(position).getOrderTrack().getLevel());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView icon;
        private TextView title, car_details, date, way;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.service_icon);
            title = itemView.findViewById(R.id.service_title);
            car_details = itemView.findViewById(R.id.car_details);
            date = itemView.findViewById(R.id.service_date);
            way = itemView.findViewById(R.id.service_way);
        }
    }
}
