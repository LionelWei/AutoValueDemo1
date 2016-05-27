package android.example.com.autovaluedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.AutoValueGsonTypeAdapterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text1);
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foo1();
            }
        });
    }

    private void foo1() {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueGsonTypeAdapterFactory())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://open.play.cn/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        PlayService service = retrofit.create(PlayService.class);
        Call<HostValue> user = service.getHost();
        user.enqueue(new Callback<HostValue>() {
            @Override
            public void onResponse(Call<HostValue> call, Response<HostValue> response) {
                HostValue value = response.body();
                if (value != null) {
                    mTextView.setText(value.code() + "\n" + value.text());
                    for (String host : value.ext().hostUrl()) {
                        mTextView.append("\n" + host);
                    }

                } else {
                    Log.d("MY_RETRO", "value is null");
                }
            }

            @Override
            public void onFailure(Call<HostValue> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void foo() {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueGsonTypeAdapterFactory())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<PlayValue> user = service.getUser("jakewharton");
        user.enqueue(new Callback<PlayValue>() {
            @Override
            public void onResponse(Call<PlayValue> call, Response<PlayValue> response) {
                PlayValue value = response.body();
                if (value != null) {
                    mTextView.setText(value.code() + "\n" + value.avatarUrl() + "\n" + value.url());

                } else {
                    Log.d("MY_RETRO", "value is null");
                }
            }

            @Override
            public void onFailure(Call<PlayValue> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void test() {
        Animal dog = Animal.builder().name("jack").numberOfLegs(4).build();
//        Animal dog = Animal.create("jack", 4);
//        Log.d("My", dog.name());

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("", "");
            }
        }).start();
    }
}
