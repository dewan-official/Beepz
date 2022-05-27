package ds.example.beepz.Network;

import ds.example.beepz.Models.Response;
import ds.example.beepz.Models.Services;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/v1/Get/Customer/active/request")
    Call<Response> getServices(@Query("CustomerId") int customerID);
}
