package com.github.romankh3.maventemplaterepository;


import com.github.romankh3.maventemplaterepository.utils.Initializer;
import com.github.romankh3.maventemplaterepository.utils.Instruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit-level testing for {@link MavenTemplateRepository} object.
 */
public class MavenTemplateRepositoryTest {

    @Test
    public void shouldNotMoveIfOutSideOfLawn() {
        Initializer initializer = new Initializer(0, 0);
        initializer.addInstruction(new Instruction(0, 0, 'N', "A"));
        initializer.addInstruction(new Instruction(0, 0, 'S', "A"));
        initializer.addInstruction(new Instruction(0, 0, 'E', "A"));
        initializer.addInstruction(new Instruction(0, 0, 'W', "A"));

        assertEquals("0 0 N 0 0 S 0 0 E 0 0 W", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void turnLeft() {
        Initializer initializer = new Initializer(0, 0);
        initializer.addInstruction(new Instruction(0, 0, 'N', "G"));
        initializer.addInstruction(new Instruction(0, 0, 'E', "G"));
        initializer.addInstruction(new Instruction(0, 0, 'S', "G"));
        initializer.addInstruction(new Instruction(0, 0, 'W', "G"));

        assertEquals("0 0 E 0 0 S 0 0 W 0 0 N", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void turnRight() {
        Initializer initializer = new Initializer(0, 0);
        initializer.addInstruction(new Instruction(0, 0, 'N', "D"));
        initializer.addInstruction(new Instruction(0, 0, 'W', "D"));
        initializer.addInstruction(new Instruction(0, 0, 'S', "D"));
        initializer.addInstruction(new Instruction(0, 0, 'E', "D"));

        assertEquals("0 0 W 0 0 S 0 0 E 0 0 N", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void advanceNorth() {
        Initializer initializer = new Initializer(1, 1);
        initializer.addInstruction(new Instruction(0, 0, 'N', "A"));
        assertEquals("0 1 N", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void advanceSud() {
        Initializer initializer = new Initializer(1, 1);
        initializer.addInstruction(new Instruction(0, 1, 'S', "A"));
        assertEquals("0 0 S", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void advanceRight() {
        Initializer initializer = new Initializer(1, 1);
        initializer.addInstruction(new Instruction(0, 1, 'W', "A"));
        assertEquals("1 1 W", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void advanceLeft() {
        Initializer initializer = new Initializer(1, 1);
        initializer.addInstruction(new Instruction(1, 1, 'E', "A"));
        assertEquals("0 1 E", MavenTemplateRepository.runActions(initializer, false)) ;
    }

    @Test
    public void testSample() {
        Initializer initializer = new Initializer(5, 5);
        initializer.addInstruction(new Instruction(1, 2, 'N', "GAGAGAGAA"));
        initializer.addInstruction(new Instruction(3, 3, 'E', "AA DAADADDA"));
        assertEquals("1 3 N 1 5 E", MavenTemplateRepository.runActions(initializer, false)) ;
    }

}
