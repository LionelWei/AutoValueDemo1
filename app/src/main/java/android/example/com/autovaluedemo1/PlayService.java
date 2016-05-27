package android.example.com.autovaluedemo1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lionel on 2016/5/28.
 */
public interface PlayService {
    @GET("api/v2/egame/host.json")
    Call<HostValue> getHost();
}
