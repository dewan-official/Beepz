package ds.example.beepz.Views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ds.example.beepz.Models.Services;
import ds.example.beepz.Models.ServicesItem;
import ds.example.beepz.R;
import ds.example.beepz.Views.adapter.MyServices;
import ds.example.beepz.viewmodel.ServicesViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar loading;
    private MyServices adapter;

    private ServicesViewModel viewModel;

    private List<ServicesItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.services_recycler);
        loading = findViewById(R.id.loading);

        items = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        adapter = new MyServices(items, this);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ServicesViewModel.class);

        viewModel.loading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                loading.setVisibility(aBoolean ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.getFailure().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, "Error: "+s, Toast.LENGTH_LONG).show();
            }
        });

        viewModel.getSuccess().observe(this, new Observer<Services>() {
            @Override
            public void onChanged(Services services) {
                if(services.getData().size() > 0){
                    items.clear();
                    items.addAll(services.getData());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        viewModel.init(34);
    }
}