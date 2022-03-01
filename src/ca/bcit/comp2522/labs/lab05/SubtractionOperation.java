package ca.bcit.comp2522.labs.lab05;

/**
 * A Subtraction Operator.
 *
 * @author wilson scott
 * @version 2022
 */
public class SubtractionOperation extends AbstractOperation {
    /**
     * A char representing the Subtraction operator.
     */
    static final char SUBTRACTION_CODE = '-';

    /**
     * Constructs an object of type SubtractionOperation.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Returns the difference of two operands.
     *
     * @param operandA an int representing the first operand
     * @param operandB an int representing the second operand
     * @return an int representing the difference between two operands
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }
}
