package ds.example.beepz.utils;

import android.icu.text.SimpleDateFormat;
import android.util.Log;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ds.example.beepz.Network.ApiInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppCons {
    private static final String[] month = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final String BASE_URL = "http://netvia.r-y-x.net/";
    public static final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(160, TimeUnit.SECONDS)
            .readTimeout(160, TimeUnit.SECONDS)
            .writeTimeout(160, TimeUnit.SECONDS)
            .build();
    public static final ApiInterface apiCall = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiInterface.class);

    public static String convertTime(String bookingDate) {
        String[] date = bookingDate.split(" ")[0].split("/");
        return date[1]+" "+month[Integer.parseInt(date[0])]+" "+date[2];
    }
}
