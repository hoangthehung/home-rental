package com.hunghoang.homerental.util.logging;

public enum Level {

    OFF(0), ERROR(1), WARN(2), INFO(3), DEBUG(4), TRACE(5);

    private final int levelAsInt;

    Level(int levelAsInt) {
        this.levelAsInt = levelAsInt;
    }

    public int getLevelAsInt() {
        return levelAsInt;
    }

}
