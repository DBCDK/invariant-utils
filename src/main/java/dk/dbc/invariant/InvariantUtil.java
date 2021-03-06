/*
 * Copyright Dansk Bibliotekscenter a/s. Licensed under GPLv3
 * See license text in LICENSE.txt or at https://opensource.dbc.dk/licenses/gpl-3.0/
 */

package dk.dbc.invariant;

/**
 * Utility class for the enforcing of invariants.
 *
 * Due to GWT compatibility no java7 constructs are allowed,
 */
public class InvariantUtil {
    private InvariantUtil() { }

    /**
     * Simple convenience method to check an argument for equality
     * with {@code null}. If the argument is {@code null} then a
     * NullPointerException is thrown. If the argument is other than
     * {@code null} the object is returned as is.
     *
     * @param object object to test for {@code null}.
     * @param parameterName name of the tested parameter. This name is used in the exception message.
     * @param <T> the type of the object being  tested for {@code null}
     *
     * @return the {@code null} tested object
     *
     * @throws NullPointerException if {@code obj} is {@code null}.
     */
    public static <T> T checkNotNullOrThrow(T object, String parameterName)
            throws NullPointerException {
        if (object == null) {
            final String message = "Value of parameter '" + parameterName + "' cannot be null";
            throw new NullPointerException(message);
        }
        return object;
    }

    /**
     * Simple convenience method to check that a string is not empty
     * If the string is empty then a IllegalArgumentException is thrown.
     * If the argument is other than that the string is returned as is.
     *
     * @param stringObject string to test for {@code null} or empty.
     * @param parameterName name of the tested parameter. This name is used in the exception message.
     *
     * @return the empty tested object
     *
     * @throws IllegalArgumentException if {@code stringObject} is empty
     */
    public static String checkNotEmptyOrThrow(String stringObject, String parameterName)
            throws IllegalArgumentException {
        if (stringObject != null && stringObject.trim().isEmpty()) {
            final String message = "Value of parameter '" + parameterName + "' cannot be empty";
            throw new IllegalArgumentException(message);
        }
        return stringObject;
    }

    /**
     * Simple convenience method to check that a string is not null or empty
     * If the string is {@code null} then a NullPointerException is thrown.
     * If the string is empty  then a IllegalArgumentException is thrown.
     * If the argument is other than that the string is returned as is.
     *
     * @param stringObject string to test for {@code null} or empty.
     * @param parameterName name of the tested parameter. This name is used in the exception message.
     *
     * @return the {@code null} or empty tested object
     *
     * @throws NullPointerException if {@code stringObject} is {@code null}.
     * @throws IllegalArgumentException if {@code stringObject} is empty
     */
    public static String checkNotNullNotEmptyOrThrow(String stringObject, String parameterName)
            throws NullPointerException, IllegalArgumentException {
        checkNotNullOrThrow(stringObject, parameterName);
        if (stringObject.trim().isEmpty()) {
            final String message = "Value of parameter '" + parameterName + "' cannot be empty";
            throw new IllegalArgumentException(message);
        }
        return stringObject;
    }

    /**
     * Simple convenience method to check that a given long is larger than or equal to given bound.
     * If the below the bound then an IllegalArgumentException is thrown, otherwise
     * the value is returned as is.
     *
     * @param value value to test against lower bound
     * @param parameterName name of the tested parameter. This name is used in the exception message.
     * @param bound lower bound
     *
     * @return the {@code bound} checked value
     *
     * @throws IllegalArgumentException if {@code value} is less than {@code bound}
     */
    public static long checkLowerBoundOrThrow(long value, String parameterName, long bound)
            throws IllegalArgumentException {
        if (value < bound) {
            final String message = "Value of parameter '" + parameterName + "' must be larger than or equal to " + bound;
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    /**
     * Simple convenience method to check that a given int is larger than or equal to given bound.
     * If the below the bound then an IllegalArgumentException is thrown, otherwise
     * the value is returned as is.
     * @param value value to test against lower bound
     * @param parameterName name of the tested parameter. This name is used in the exception message.
     * @param bound lower bound
     *
     * @return the {@code bound} checked value
     *
     * @throws IllegalArgumentException if {@code value} is less than {@code bound}
     */
    public static int checkIntLowerBoundOrThrow(int value, String parameterName, int bound)
            throws IllegalArgumentException {
        if (value < bound) {
            final String message = "Value of parameter '" + parameterName + "' must be larger than or equal to " + bound;
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
