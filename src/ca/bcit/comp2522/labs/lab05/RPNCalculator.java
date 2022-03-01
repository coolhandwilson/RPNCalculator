package ca.bcit.comp2522.labs.lab05;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

/**
 * Simulates an RPN Calculator.
 *
 * @author wilson scott
 * @version 2022
 */
public class RPNCalculator {
    private static final int MIN_STACK_SIZE = 2;

    private final Stack stack;

    /**
     * Constructs an object of type RPNCalculator.
     *
     * @param stackSize an int representing the size of the stack
     * @throws IllegalArgumentException where stackSize less than MIN_STACK_SIZE
     */
    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException("Stack Size lower than Minimum Stack Size.");
        }
        this.stack = new Stack(stackSize);
    }

    /**
     * Processes a formula in RPN Format.
     *
     * @param formula a String representing a mathematical formula in RPN format
     * @return an int representing the result of the formula
     * @throws IllegalArgumentException where formula is null or zero length
     */
    public int processFormula(final String formula) {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException("Null parameter detected.");
        }
        final Scanner scan = new Scanner(formula);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                stack.push(scan.nextInt());
            } else {
                Operation operation = getOperation(scan.next().charAt(0));
                this.perform(operation);
            }
        }
        return getResult();
    }

    private Operation getOperation(final char symbol) {
        switch (symbol) {
            case '+' -> {
                return new AdditionOperation();
            }
            case '*' -> {
                return new MultiplicationOperation();
            }
            case '-' -> {
                return new SubtractionOperation();
            }
            case '/' -> {
                return new DivisionOperation();
            }
            default -> {
                throw new IllegalArgumentException("Invalid Operator Detected.");
            }
        }
    }

    private void perform(final Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        final int tempOne = stack.pop();
        final int tempTwo = stack.pop();
        stack.push(operation.perform(tempTwo, tempOne));
    }

    /**
     * Returns the result of the last operation completed by the calculator.
     *
     * @return an int representing the result of the last operation
     */
    public int getResult() {
        return stack.peek();
    }


    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final IllegalArgumentException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final BufferOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final BufferUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }

    /**
     * Returns a String representation of the RPNCalculator object.
     *
     * @return representation of the RPNCalculator object as a String
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RPNCalculator{");
        sb.append("stack=").append(stack);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Calculators are equal if their states are equal.
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
        RPNCalculator that = (RPNCalculator) other;
        return stack.equals(that.stack);
    }

    /**
     * Returns a hashCode for this instance of the RPNCalculator class.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        int result;
        final int firstPrime = 17;
        final int secondPrime = 37;
        result = secondPrime * firstPrime + this.stack.hashCode();
        return result;
    }
}
