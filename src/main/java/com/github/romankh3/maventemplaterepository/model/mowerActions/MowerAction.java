package com.github.romankh3.maventemplaterepository.model.mowerActions;

import com.github.romankh3.maventemplaterepository.model.Lawn;
import com.github.romankh3.maventemplaterepository.model.Mower;

/**
 * @author: Florian A.
 */
public abstract class MowerAction {
    public abstract void execute(Mower mower, Lawn lawn);
}