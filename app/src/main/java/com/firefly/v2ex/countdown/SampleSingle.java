package com.firefly.v2ex.countdown;

/**
 * Created by jason on 9/6/17.
 */

class SampleSingle {
    private static final SampleSingle ourInstance = new SampleSingle();

    static SampleSingle getInstance() {
        return ourInstance;
    }

    private SampleSingle() {
    }
}
