/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Date;

/**
 *
 * @author kylem
 */
public class Validation {

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

    public static void validateInt(int value, String fieldName, int maxValue, int minValue) {
        if (value > maxValue) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d", fieldName, maxValue));
        }

        if (value < minValue) {
            throw new IllegalArgumentException(String.format("%s cannot be less then %d", fieldName, minValue));
        }
    }

    public static void validateDate(Date value, String fieldName, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {

            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        }
    }
    
    public static void validateGender(String value, String fieldName, int maxLength, boolean isAllowed) {
        validateString(value, fieldName, maxLength, isAllowed);
        
        if (!value.equals("M") || !value.equals("F")) {
            throw new IllegalArgumentException(String.format("%s must be M or F", fieldName));
        }
    }
}
