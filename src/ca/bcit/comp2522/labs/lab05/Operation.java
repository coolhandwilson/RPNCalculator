package ca.bcit.comp2522.labs.lab05;

/**
 * Simulates a mathematical operation.
 *
 * @author wilson scott
 * @version 2022
 */
public interface Operation {
    /**
     * Returns the operand symbol as a String.
     *
     * @return a String representing the operand
     */
    char getSymbol();

    /**
     * Creates a blueprint for performing a mathematical operation.
     *
     * @param operandA an int representing the first operand
     * @param operandB an int representing the second operand
     * @return an int representing the result of the mathematical operation
     */
    int perform(int operandA, int operandB);
}
