package com.github.romankh3.maventemplaterepository;

import com.github.romankh3.maventemplaterepository.model.ActionsRegistry;
import com.github.romankh3.maventemplaterepository.model.Lawn;
import com.github.romankh3.maventemplaterepository.model.Mower;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MoveForwardAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.MowerAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnLeftAction;
import com.github.romankh3.maventemplaterepository.model.mowerActions.TurnRightAction;
import com.github.romankh3.maventemplaterepository.utils.Initializer;
import com.github.romankh3.maventemplaterepository.utils.Instruction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class for Java Repository Template.
 */
public class MavenTemplateRepository {

    public static void main(String[] args) {
        if (args.length > 0) {
            String readMyFileName = args[0];
            List<Initializer> dataList = readFile(readMyFileName);
            dataList.forEach(initializer -> runActions(initializer, true));
        } else {
            System.out.println("A file is needed as an argument to run this script");
        }
    }

    public static String runActions(Initializer initializer, boolean showLogs) {
        StringBuilder builder = new StringBuilder("");
        Lawn lawn = new Lawn(initializer.getMaxLawnXAxis(), initializer.getMaxLawnYAxis());
        initializer.getInstructions().forEach(instruction -> {
            Mower mower = new Mower(
                instruction.getXAxis(),
                instruction.getYAxis(),
                instruction.getOrientation(),
                ActionsRegistry.getActions()
            );

            for (Character character: instruction.getActions().toCharArray()) {
                mower.moveMower(character, lawn);
            }
            builder.append(mower).append(" ");
        });
        if(builder.length() > 0) builder.deleteCharAt(builder.length()-1);
        if(showLogs) System.out.print(builder);
        return builder.toString();
    }

    public static List<Initializer> readFile(String fileName) {
        List<Initializer> dataList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            if (lines.size() < 3) {
                throw new IllegalArgumentException("The file must contain at least a lawn and one mower with instructions.");
            }

            // Read lawn dimensions (first line)
            String[] lawnDimensions = lines.get(0).split(" ");
            int rightCornerXAxis = Integer.parseInt(lawnDimensions[0]);
            int rightCornerYAxis = Integer.parseInt(lawnDimensions[1]);

            // Create the lawn initializer
            Initializer initializer = new Initializer(rightCornerXAxis, rightCornerYAxis);

            // Read mower positions and instructions
            for (int i = 1; i < lines.size(); i += 2) {
                if (i + 1 >= lines.size()) {
                    throw new IllegalArgumentException("Each mower position must be followed by an instruction line.");
                }

                // Read mower's initial position and orientation (odd-numbered line)
                String[] positionData = lines.get(i).split(" ");
                int x = Integer.parseInt(positionData[0]);
                int y = Integer.parseInt(positionData[1]);
                char direction = positionData[2].charAt(0);

                // Read mower's movement instructions (next even-numbered line)
                String actions = lines.get(i + 1).trim();

                // Create the instruction and add it to the initializer
                Instruction instruction = new Instruction(x, y, direction, actions);
                initializer.addInstruction(instruction);
            }

            // Add the lawn initializer to the list
            dataList.add(initializer);

        } catch (IOException e) {
            System.err.println("Error while reading file : " + e.getMessage());
        }

        return dataList;
    }
}
