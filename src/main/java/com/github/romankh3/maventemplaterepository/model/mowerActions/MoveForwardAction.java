package com.github.romankh3.maventemplaterepository.model.mowerActions;

import com.github.romankh3.maventemplaterepository.model.Lawn;
import com.github.romankh3.maventemplaterepository.model.Mower;

/**
 * @author: Florian A.
 */
public class MoveForwardAction extends MowerAction {
    @Override
    public void execute(Mower mower, Lawn lawn) {
        mower.moveForward(lawn);
    }
}
