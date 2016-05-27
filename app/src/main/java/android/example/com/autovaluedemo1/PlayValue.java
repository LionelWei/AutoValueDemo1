package android.example.com.autovaluedemo1;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lionel on 2016/5/27.
 */
@AutoValue
public abstract class PlayValue {
/*
    login: "LionelWei",
    id: 7624577,
    avatar_url: "https://avatars.githubusercontent.com/u/7624577?v=3",
    gravatar_id: "",
    url: "https://api.github.com/users/LionelWei",
    html_url: "https://github.com/LionelWei",
    followers_url: "https://api.github.com/users/LionelWei/followers",
    following_url: "https://api.github.com/users/LionelWei/following{/other_user}",
    gists_url: "https://api.github.com/users/LionelWei/gists{/gist_id}",
    starred_url: "https://api.github.com/users/LionelWei/starred{/owner}{/repo}",
    subscriptions_url: "https://api.github.com/users/LionelWei/subscriptions",
    organizations_url: "https://api.github.com/users/LionelWei/orgs",
    repos_url: "https://api.github.com/users/LionelWei/repos",
    events_url: "https://api.github.com/users/LionelWei/events{/privacy}",
    received_events_url: "https://api.github.com/users/LionelWei/received_events",
    type: "User",
    site_admin: false,
    name: null,
    company: null,
    blog: null,
    location: null,
    email: null,
    hireable: null,
    bio: null,
    public_repos: 6,
    public_gists: 0,
    followers: 0,
    following: 2,
    created_at: "2014-05-19T01:53:48Z",
    updated_at: "2016-05-21T05:54:56Z"
*/
    abstract String login();
    abstract int code();
    @SerializedName("avatar_url")
    abstract String avatarUrl();
    @SerializedName("gravatar_id")
    abstract String gravatarId();
    abstract String url();

    // The public static method returning a TypeAdapter<Foo> is what
    // tells auto-value-gson to create a TypeAdapter for Foo.
    public static TypeAdapter<PlayValue> typeAdapter(Gson gson) {
        return new AutoValue_PlayValue.GsonTypeAdapter(gson);
    }
}
