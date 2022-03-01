package ca.bcit.comp2522.labs.lab05;

/**
 * An Addition Operator.
 *
 * @author wilson scott
 * @version 2022
 */
public class AdditionOperation extends AbstractOperation {
    /**
     * A char representing the Addition operator.
     */
    static final char ADDITION_CODE = '+';

    /**
     * Constructs an object of type AdditionOperation.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Returns the sum of two operands.
     *
     * @param operandA an int representing the first operand
     * @param operandB an int representing the second operand
     * @return an int representing the sum of the two operands
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }
}
