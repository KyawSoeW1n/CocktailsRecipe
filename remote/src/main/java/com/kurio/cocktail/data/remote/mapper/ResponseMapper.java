package com.kurio.cocktail.data.remote.mapper;

public interface ResponseMapper<R, E> {

    E mapFromResponse(R response);

}
