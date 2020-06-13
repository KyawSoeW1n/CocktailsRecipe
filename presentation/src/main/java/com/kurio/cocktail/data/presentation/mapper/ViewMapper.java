package com.kurio.cocktail.data.presentation.mapper;

public interface ViewMapper<V, D> {
    V mapToView(D domainModel);
}
