package com.github.romankh3.maventemplaterepository.model;

/**
 * @author Florian A.
 * Some Lawn waiting to be mowed ...
 */
public class Lawn {
    private final int minX;
    private final int minY;
    private final int maxX;
    private final int maxY;

    /**
     * @param maxX top right corner position on xAxis
     * @param maxY top right corner position on yAxis
     */
    public Lawn(int maxX, int maxY) {
        this.minX = 0;
        this.minY = 0;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }
}
