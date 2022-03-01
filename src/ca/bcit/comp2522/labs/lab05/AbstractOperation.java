package ca.bcit.comp2522.labs.lab05;

/**
 * An Operation.
 *
 * @author wilson scott
 * @version 2022
 */
public abstract class AbstractOperation implements Operation {
    /**
     * The type of operation.
     */
    protected char operationType;

    /**
     * Constructs an object of type Operation.
     *
     * @param type a char representing an operation type
     */
    public AbstractOperation(final char type) {
        this.operationType = type;
    }

    /**
     * Returns a char representation of an operator.
     *
     * @return a char representing an operator
     */
    public final char getSymbol() {
        return operationType;
    }

    /**
     * Returns a String representation of the AbstractOperation.
     *
     * @return representation of the AbstractOperation as a String
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbstractOperation{");
        sb.append("operationType=").append(operationType);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Operations are equal if their states are equal.
     *
     * @param other Object
     * @return true if the current object and parameter object are the same, else false
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!this.getClass().equals(other.getClass())) {
            return false;
        }

        AbstractOperation that = (AbstractOperation) other;

        return operationType == that.operationType;
    }

    /**
     * Returns a hashCode for this instance of the operationType.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        int result;
        final int firstPrime = 17;
        final int secondPrime = 37;
        result = secondPrime * firstPrime + ((Character) operationType).hashCode();
        return result;
    }
}
