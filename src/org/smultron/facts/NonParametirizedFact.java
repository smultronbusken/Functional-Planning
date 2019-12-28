package org.smultron.framework.planning.facts;

import java.util.HashMap;

public abstract class NonParametirizedFact<R> extends Fact<Object, R> {
    
    public NonParametirizedFact(R startValue) {
        super(startValue);
        values = new HashMap<>();
    }

    @Override
    public R get(Object argument) {
        return super.get(0);
    }

    @Override
    public void set(Object argument, R value) {
        super.set(0, value);
    }

    @Override
    public String toString() {
        return get(0).toString();
    }
}
