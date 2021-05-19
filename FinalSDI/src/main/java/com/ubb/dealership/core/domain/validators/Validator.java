package com.ubb.dealership.core.domain.validators;


import com.ubb.dealership.core.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}