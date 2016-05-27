package android.example.com.autovaluedemo1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lionel on 2016/5/28.
 */
public interface GitHubService {
    @GET("users/{user}")
    Call<PlayValue> getUser(@Path("user") String user);
}
