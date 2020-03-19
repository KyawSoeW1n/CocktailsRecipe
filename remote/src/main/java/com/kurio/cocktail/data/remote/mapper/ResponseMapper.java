package com.kurio.cocktail.data.remote.mapper;

public interface ResponseMapper<R, E> {

    public E mapFromResponse(R response);

}
