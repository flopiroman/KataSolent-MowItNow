package com.github.romankh3.maventemplaterepository.model;

/**
 * @author Florian A.
 */
public enum Orientation {
    N("N"), //North
    E("E"), //Est
    W("W"), //West
    S("S"); //Sud

    final String value;

    Orientation(String value) {
        this.value = value;
    }
}
