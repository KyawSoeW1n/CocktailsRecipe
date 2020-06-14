package com.kurio.cocktail.cache.mapper;

public interface CacheMapper<C, E> {

    public E mapFromCached(C cached);

    public C mapToCached(E entity);

}
