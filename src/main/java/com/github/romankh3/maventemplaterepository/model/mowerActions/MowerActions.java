package com.github.romankh3.maventemplaterepository.model.mowerActions;

/**
 * @author Florian A.
 */
public enum MowerActions {
    D("D"), //Turn Right
    G("G"), //Turn Left
    A("A"); //Move forward

    final String value;

    MowerActions(String value) {
        this.value = value;
    }
}
