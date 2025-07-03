package io.github.andrevsc.movimento_component.provider;

import io.github.andrevsc.movimento_component.required.IValidationProvider;
import org.springframework.stereotype.Component;

@Component
public class DefaultValidationProvider implements IValidationProvider {
    
    @Override
    public void validateRequired(String fieldName, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " é obrigatório");
        }
    }
    
    @Override
    public void validateRange(String fieldName, Integer value, int min, int max) {
        if (value == null || value < min || value > max) {
            throw new IllegalArgumentException(fieldName + " deve estar entre " + min + " e " + max);
        }
    }
    
    @Override
    public void validatePositive(String fieldName, Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(fieldName + " deve ser maior que zero");
        }
    }
}
