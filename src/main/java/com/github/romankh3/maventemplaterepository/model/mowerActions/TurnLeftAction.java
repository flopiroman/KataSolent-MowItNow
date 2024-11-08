package com.github.romankh3.maventemplaterepository.model.mowerActions;

import com.github.romankh3.maventemplaterepository.model.Lawn;
import com.github.romankh3.maventemplaterepository.model.Mower;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MowerAction;

/**
 * @author: Florian A.
 */
public class TurnLeftAction extends MowerAction {
    @Override
    public void execute(Mower mower, Lawn lawn) {
        mower.turnLeft();
    }
}
