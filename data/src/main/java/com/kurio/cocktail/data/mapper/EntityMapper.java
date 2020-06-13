package com.kurio.cocktail.data.mapper;

public interface EntityMapper<E, D> {
    D mapFromEntity(E entity);

    E mapToEntity(D domainModel);
}
