package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CocktailDetailMapper implements EntityMapper<CocktailDetailEntity, CocktailDetail> {

    @Inject
    public CocktailDetailMapper() {
    }

    @Override
    public CocktailDetail mapFromEntity(CocktailDetailEntity cocktailDetailEntity) {
        return MapperUtils.transform(cocktailDetailEntity, CocktailDetail.class);
    }

    @Override
    public CocktailDetailEntity mapToEntity(CocktailDetail cocktailDetail) {
        return MapperUtils.transform(cocktailDetail, CocktailDetailEntity.class);
    }

}
