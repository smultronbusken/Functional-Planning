package org.smultron.planning.facts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Fact<T, R>  {

    public String name;

    public Fact(R defaultValue) {
        this.defaultValue = defaultValue;
        values = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact that = (Fact) o;
        return Objects.equals(values, that.values) &&
                Objects.equals(name, that.name);
    }

    protected Map<T, R> values;

    public final R defaultValue;

    public abstract Fact<T, R> clone();

    public R get(Object argument) {
        values.putIfAbsent((T) argument, defaultValue);
        return values.get((T) argument);
    }

    public void set(Object argument, R value) {
        values.put((T) argument, value);
    }

    public Map<T, R> values() {
        return values;
    }



    /**
     *
     * @param factName
     * @return
     */
    public static Fact getFact(List<Fact> facts, String factName) {
        for (Fact fact : facts) {
            if (fact.name.equals(factName))
                return fact;
        }
        return null;
    }
}
