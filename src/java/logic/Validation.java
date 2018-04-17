/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Date;

/**
 * a common class that holds validation for all the logic classes
 *
 * @author kyle, keith
 */
public class Validation {

    /**
     * makes sure the string to be saved, can be saved
     * @param value
     * @param fieldName
     * @param maxLength
     * @param isNullAllowed 
     */
    public static void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {
            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        } else if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }

    /**
     * makes sure the integer to save, can be saved
     * @param value
     * @param fieldName
     * @param maxValue
     * @param minValue 
     */
    public static void validateInt(int value, String fieldName, int maxValue, int minValue) {
        if (value > maxValue) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d", fieldName, maxValue));
        }

        if (value < minValue) {
            throw new IllegalArgumentException(String.format("%s cannot be less then %d", fieldName, minValue));
        }
    }

    /**
     * makes sure the date is a valid date before saving it in the database
     * @param value
     * @param fieldName
     * @param isNullAllowed 
     */
    public static void validateDate(Date value, String fieldName, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {

            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        }
    }
    
    /**
     * specific to an employee, but used to make sure the gender is either M or F
     * @param value
     * @param fieldName
     * @param maxLength
     * @param isAllowed 
     */
    public static void validateGender(String value, String fieldName, int maxLength, boolean isAllowed) {
        validateString(value, fieldName, maxLength, isAllowed);
        
        if (!value.equals("M") || !value.equals("F")) {
            throw new IllegalArgumentException(String.format("%s must be M or F", fieldName));
        }
    }
}
