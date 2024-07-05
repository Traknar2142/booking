package com.prime.booking.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

/**
 * Интерфейс формирования спецификации фильтрации сущности.
 *
 * @param <T> Тип фильтруемой сущности
 */
public interface Filter<T> {
    @Nullable
    Specification<T> toSpecification();
}
