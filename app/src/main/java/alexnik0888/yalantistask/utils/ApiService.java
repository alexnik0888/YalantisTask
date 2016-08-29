package alexnik0888.yalantistask.utils;

import java.util.List;

import alexnik0888.yalantistask.model.Task;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Alex on 12.08.2016.
 */
public interface ApiService  {
    String BASE_URL = "http://dev-contact.yalantis.com/rest/v1/";

    @GET("tickets")
    Observable<List<Task>> getTasks(@Query("offset") int offset,
                                      @Query("state") String state,
                                      @Query("amount") int amount);

    class Factory{
        public static ApiService newApiService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            return retrofit.create(ApiService.class);
        }
    }
}
