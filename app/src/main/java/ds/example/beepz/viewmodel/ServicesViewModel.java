package ds.example.beepz.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ds.example.beepz.Models.ModelListener;
import ds.example.beepz.Models.Services;
import ds.example.beepz.repository.GetServicesRepository;

public class ServicesViewModel extends ViewModel implements ModelListener {
    private MutableLiveData<Services> success = new MutableLiveData<>();
    private MutableLiveData<String> failure = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private GetServicesRepository repository;

    public void init(int userID){
        if(repository == null){
            repository = GetServicesRepository.getInstance();
        }
        repository.getServices(userID, this);
    }

    public LiveData<Services> getSuccess(){
        return success;
    }

    public LiveData<String> getFailure(){
        return failure;
    }

    public LiveData<Boolean> loading(){
        return loading;
    }

    @Override
    public void onSuccess(Services services) {
        loading.postValue(false);
        success.postValue(services);
    }

    @Override
    public void onFailure(String msg) {
        loading.postValue(false);
        failure.postValue(msg);
    }

    @Override
    public void onStart() {
        loading.postValue(true);
    }
}
