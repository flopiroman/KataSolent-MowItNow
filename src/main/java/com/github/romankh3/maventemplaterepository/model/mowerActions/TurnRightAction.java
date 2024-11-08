package com.github.romankh3.maventemplaterepository.model.mowerActions;

import com.github.romankh3.maventemplaterepository.model.Lawn;
import com.github.romankh3.maventemplaterepository.model.Mower;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MowerAction;

/**
 * @author: Florian A.
 */
public class TurnRightAction extends MowerAction {
    @Override
    public void execute(Mower mower, Lawn lawn) {
        mower.turnRight();
    }
}
