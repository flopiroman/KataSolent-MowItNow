package com.github.romankh3.maventemplaterepository.model;

import com.github.romankh3.maventemplaterepository.model.mowerActions.MoveForwardAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MowerAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnLeftAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnRightAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Florian A.
 * Principal object of this project.
 * This one must change his position depending on some specified actions
 */
public class Mower {
    private int xAxis;
    private int yAxis;
    private Orientation orientation;
    private static final Map<Character, MowerAction> actions = new HashMap<>();

    /**
     * @param xAxis initial position on xAxis
     * @param yAxis initial position on yAxis
     * @param orientation initial orientation
     */
    public Mower(int xAxis, int yAxis, Orientation orientation) {
        this.orientation = orientation;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }


    // Action list
    static {
        actions.put('G', new TurnLeftAction());
        actions.put('D', new TurnRightAction());
        actions.put('A', new MoveForwardAction());
    }

    public void moveMower(Character action, Lawn lawn) {
        MowerAction mowerAction = actions.get(action);
        if (mowerAction != null) {
            mowerAction.execute(this, lawn);
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case E:
                setOrientation(Orientation.S);
                break;
            case S:
                setOrientation(Orientation.W);
                break;
            case W:
                setOrientation(Orientation.N);
                break;
            case N:
                setOrientation(Orientation.E);
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case E:
                setOrientation(Orientation.N);
                break;
            case N:
                setOrientation(Orientation.W);
                break;
            case W:
                setOrientation(Orientation.S);
                break;
            case S:
                setOrientation(Orientation.E);
                break;
            default:
                break;
        }
    }

    public void moveForward(Lawn lawn) {
        switch (orientation) {
            case N:
                if (yAxis + 1 <= lawn.getMaxY()) setYAxis(yAxis + 1);
                break;
            case W:
                if (xAxis + 1 <= lawn.getMaxX()) setXAxis(xAxis + 1);
                break;
            case S:
                if (yAxis - 1 >= lawn.getMinY()) setYAxis(yAxis - 1);
                break;
            case E:
                if (xAxis - 1 >= lawn.getMinX()) setXAxis(xAxis - 1);
                break;
            default:
                break;
        }
    }

    private void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    private void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    private void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }



    @Override
    public String toString() {
        return xAxis + " " + yAxis + " " + orientation.toString();
    }
}
