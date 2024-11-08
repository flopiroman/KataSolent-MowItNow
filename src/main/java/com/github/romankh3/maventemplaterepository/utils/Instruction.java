package com.github.romankh3.maventemplaterepository.utils;

import com.github.romankh3.maventemplaterepository.model.Orientation;

/**
 * @author: Florian A.
 * Corresponding to mower's initial position + a list of actions (saved as a string)
 * Fields are final because we don't want to allow updating them
 */
public class Instruction {
    private final int mowerInitialXAxis;
    private final int mowerInitialYAxis;
    private final Orientation orientation;
    private final String actions;

    /**
     * @param mowerInitialXAxis mower's initial position on xAxis
     * @param mowerInitialYAxis mower's initial position on yAxis
     * @param orientation mower's initial orientation
     * @param actions upcoming actions
     */
    public Instruction(int mowerInitialXAxis, int mowerInitialYAxis, char orientation, String actions) {
        this.mowerInitialXAxis = mowerInitialXAxis;
        this.mowerInitialYAxis = mowerInitialYAxis;
        this.orientation = Orientation.valueOf(String.valueOf(orientation));
        this.actions = actions;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getActions() {
        return actions;
    }

    public int getYAxis() {
        return mowerInitialYAxis;
    }

    public int getXAxis() {
        return mowerInitialXAxis;
    }
}
