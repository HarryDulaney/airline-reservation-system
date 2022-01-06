package com.application.model;

public class GlobalView implements java.io.Serializable, Comparable<GlobalView> {
    // Values to expose to all Views (Globally)
    public int priority = -1;

    public GlobalView(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(GlobalView that) {
        return Integer.compare(this.priority, that.priority);
    }

}
