package ds.example.beepz.repository;

import android.util.Log;

import ds.example.beepz.Models.ModelListener;
import ds.example.beepz.Models.Services;
import ds.example.beepz.utils.AppCons;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetServicesRepository {

    private static GetServicesRepository instance;
    private ModelListener loadingInterface;
    private int userID;

    public static GetServicesRepository getInstance(){
        if(instance == null){
            instance = new GetServicesRepository();
        }return instance;
    }

    public void getServices(int userID, ModelListener loadingInterface) {
        this.userID = userID;
        this.loadingInterface = loadingInterface;
        load();
    }

    private void load() {
        loadingInterface.onStart();
        AppCons.apiCall.getServices(userID).enqueue(new Callback<ds.example.beepz.Models.Response>() {
            @Override
            public void onResponse(Call<ds.example.beepz.Models.Response> call, Response<ds.example.beepz.Models.Response> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        loadingInterface.onSuccess(response.body().getData());
                    }else{
                        loadingInterface.onFailure(response.body().getMessage());
                    }
                }else{
                    loadingInterface.onFailure("Some Error Occurs.");
                }
            }

            @Override
            public void onFailure(Call<ds.example.beepz.Models.Response> call, Throwable t) {
                loadingInterface.onFailure(t.getMessage());
            }
        });
    }
}
