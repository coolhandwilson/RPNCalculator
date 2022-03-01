package ca.bcit.comp2522.labs.lab05;

/**
 * A Multiplication operator.
 *
 * @author wilson scott
 * @version 2022
 */
public class MultiplicationOperation extends AbstractOperation {
    /**
     * A char representing the Multiplication operator.
     */
    static final char MULTIPLICATION_CODE = '*';

    /**
     * Constructs an object of type MultiplicationOperation.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Returns the product of two operands.
     *
     * @param operandA an int representing the first operand
     * @param operandB an int representing the second operand
     * @return an int representing the product of the two operands
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }
}
