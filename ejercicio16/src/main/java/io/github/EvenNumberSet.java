package io.github;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;

public class EvenNumberSet extends AbstractSet<Integer> {
    private HashSet<Integer> set;

    public EvenNumberSet() {
        this.set = new HashSet<>();
    }

    @Override
    public boolean add(Integer e) {
        if(e % 2 == 0) {
            set.add(e);
            return true;
        }

        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }
}
