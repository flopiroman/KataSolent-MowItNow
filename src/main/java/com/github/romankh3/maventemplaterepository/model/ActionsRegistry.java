package com.github.romankh3.maventemplaterepository.model;

import com.github.romankh3.maventemplaterepository.model.mowerActions.MoveForwardAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MowerAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnLeftAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnRightAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Florian A.
 * Adding a Singleton for actions list initialization
 */
public class ActionsRegistry {
    private static final Map<Character, MowerAction> actions = new HashMap<>();

    static {
        actions.put('G', new TurnLeftAction());
        actions.put('D', new TurnRightAction());
        actions.put('A', new MoveForwardAction());
    }

    public static Map<Character, MowerAction> getActions() {
        return actions;
    }
}
