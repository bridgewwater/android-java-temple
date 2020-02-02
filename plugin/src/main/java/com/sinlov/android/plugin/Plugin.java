package com.sinlov.android.plugin;

/**
 * this class can delete if not use Singleton
 */
public final class Plugin {

    public static Plugin getInstance() {
        return Instance.instance;
    }

    private Plugin() {
    }

    private static class Instance {
        private static final Plugin instance = new Plugin();
    }
}
