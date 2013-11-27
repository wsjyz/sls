package com.eighthinfo.sls.utils;

import java.util.*;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-27
 * Time: PM9:55
 */
public class Group<T> {

    private Map<String, List<T>> container;

    public Map<String, List<T>> groupCollection(Collection<T> collection, KeyBuilder<T> keyBuilder) {
        for (Iterator<T> i = collection.iterator(); i.hasNext(); ) {
            T o = i.next();
            put(keyBuilder.key(o), o);
        }

        return getContainer();
    }

    private void put(String key, T value) {
        List<T> row = getRow(key);
        row.add(value);
    }

    private Map<String, List<T>> getContainer() {
        if (container == null) {
            container = new HashMap<String, List<T>>();
        }
        return container;
    }

    private List<T> getRow(String key) {
        List<T> row = getContainer().get(key);
        if (row == null) {
            row = new ArrayList<T>();
            getContainer().put(key, row);
        }
        return row;
    }

    public static interface KeyBuilder<T> {
        String key(T o);
    }

}
