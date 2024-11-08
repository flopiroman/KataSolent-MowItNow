package com.github.romankh3.maventemplaterepository.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Florian A.
 * Used to initialize a lawn and collect upcoming mower's instructions
 */
public class Initializer {
    private final int maxLawnXAxis;
    private final int maxLawnYAxis;
    private final List<Instruction> instructions;


    /**
     * @param maxLawnXAxis Lawn top right corner position on xAxis
     * @param maxLawnYAxis Lawn top right corner position on yAxis
     */
    public Initializer(int maxLawnXAxis, int maxLawnYAxis) {
        this.maxLawnXAxis = maxLawnXAxis;
        this.maxLawnYAxis = maxLawnYAxis;
        this.instructions = new ArrayList<>();
    }

    public int getMaxLawnXAxis() {
        return maxLawnXAxis;
    }

    public int getMaxLawnYAxis() {
        return maxLawnYAxis;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    /**
     * @param instruction new instruction for one mower on this Initializer's lawn
     */
    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }
}
