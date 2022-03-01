package ca.bcit.comp2522.labs.lab05;

/**
 * A Division Operator.
 *
 * @author wilson scott
 * @version 2022
 */
public class DivisionOperation extends AbstractOperation {
    /**
     * A char representing the Division operator.
     */
    static final char DIVISION_CODE = '/';

    /**
     * Constructs an object of type DivisionOperation.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Returns the quotient of two operands.
     *
     * @param operandA an int representing the first operand
     * @param operandB an int representing the second operand
     * @return an int representing the quotient of two operands
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }
}
