package android.example.com.autovaluedemo1;

import com.google.auto.value.AutoValue;

/**
 * Created by Lionel on 2016/5/21.
 */
@AutoValue
public abstract class Animal {
    public static Builder builder() {
        return new AutoValue_Animal.Builder();
    }

    abstract String name();
    abstract int numberOfLegs();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String s);
        public abstract Builder numberOfLegs(int legs);
        public abstract Animal build();
    }
}
