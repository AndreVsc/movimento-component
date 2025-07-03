package io.github.andrevsc.movimento_component.required;

public interface IValidationProvider {
    void validateRequired(String fieldName, String value);
    void validateRange(String fieldName, Integer value, int min, int max);
    void validatePositive(String fieldName, Integer value);
}