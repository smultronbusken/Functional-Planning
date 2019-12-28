package org.smultron.planning.facts.commonfacts;
import org.smultron.planning.facts.NonParametirizedFact;

public class Atom extends NonParametirizedFact<Boolean> {

    public Atom(Boolean startValue) {
        super(startValue);
    }

    @Override
    public Atom clone() {
        Atom atom = new Atom(defaultValue);
        atom.setName(name);
        return atom;
    }
}
