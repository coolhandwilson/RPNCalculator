package ca.bcit.comp2522.labs.lab05;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

/**
 * Simulates a stack of operations and operands.
 *
 * @author wilson
 * @version 2022
 */
public class Stack {

    private final int[] stackValues;
    private int count;

    /**
     * Constructs an object of type Stack.
     *
     * @param arraySize an int representing the size of stackValues
     * @throws IllegalArgumentException where arraySize less than or equal to 1
     */
    public Stack(final int arraySize) {
        if (arraySize <= 1) {
            throw new IllegalArgumentException("\nInvalid array size.");
        }
        this.stackValues = new int[arraySize];
    }

    /**
     * Returns the size of the stack array.
     *
     * @return an int representing the size of the array
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Returns the number of elements in the stack array.
     *
     * @return an int representing the number of elements in the array
     */
    public int size() {
        return count;
    }

    /**
     * Returns the amount of space left in the stack.
     *
     * @return an int representing the space left in the array
     */
    public int unused() {
        return stackValues.length - count;
    }

    /**
     * Adds a new element to the stack.
     *
     * @param value an int to be added on to the stack
     * @throws BufferOverflowException where there is no space left in the stack
     */
    public void push(final int value) {
        if (this.unused() == 0) {
            throw new BufferOverflowException();
        }
        this.stackValues[this.count] = value;
        ++this.count;
    }

    /**
     * Removes, returns the last element in the Stack.
     *
     * @return an int representing the last item in the Stack
     * @throws BufferUnderflowException where pop() is called on an empty array
     */
    public int pop() {
        if (this.count == 0) {
            throw new BufferUnderflowException();
        }
        final int temp = this.stackValues[this.count - 1];
        this.stackValues[this.count - 1] = 0;
        --this.count;
        return temp;
    }

    /**
     * Returns the top element in the Stack.
     *
     * @return an int representing the topmost element in the Stack
     * @throws BufferUnderflowException where peek() is called on an empty array
     */
    public int peek() {
        if (this.count == 0) {
            throw new BufferUnderflowException();
        }
        return this.stackValues[this.count - 1];
    }

    /**
     * Returns a String representation of the Stack object.
     *
     * @return representation of the Stack as a string
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stack{");
        sb.append("stackValues=");
        if (stackValues == null) {
            sb.append("null");
        } else {
            sb.append('[');
            for (int i = 0; i < stackValues.length; ++i) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(stackValues[i]);
                sb.append(']');
            }
        }
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Stacks are equal if their states are equal.
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

        Stack stack = (Stack) other;

        if (count != stack.count) {
            return false;
        }
        return Arrays.equals(stackValues, stack.stackValues);
    }

    /**
     * Returns a hashCode for this instance of the Stack class.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        int result;
        final int firstPrime =  17;
        final int secondPrime = 37;
        result = secondPrime * firstPrime + Arrays.hashCode(this.stackValues);
        result = secondPrime * result + this.count;
        return result;
    }
}
