package android.example.com.autovaluedemo1;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lionel on 2016/5/28.
 */
@AutoValue
public abstract class HostValue {
/*
    {
        code: 0,
        text: "success",
        ext: {
            host_url: [
            "http://202.102.39.23/",
                    "http://180.96.49.15/",
                    "http://180.96.49.16/"
            ],
            app_key: "",
            cdn_url: [ ]
        }
    }
*/
    abstract int code();
    abstract String text();
    abstract Inner ext();

    @AutoValue
    public static abstract class Inner {
        @SerializedName("host_url") abstract List<String> hostUrl();
        @SerializedName("app_key") abstract String appKey();
        @SerializedName("cdn_url") abstract List<String> cdnUrl();
        public static TypeAdapter<HostValue.Inner> typeAdapter(Gson gson) {
            return new AutoValue_HostValue_Inner.GsonTypeAdapter(gson);
        }
    }
    public static TypeAdapter<HostValue> typeAdapter(Gson gson) {
        return new AutoValue_HostValue.GsonTypeAdapter(gson);
    }

}
