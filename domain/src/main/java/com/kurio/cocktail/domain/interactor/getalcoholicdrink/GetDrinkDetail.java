package com.kurio.cocktail.domain.interactor.getalcoholicdrink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.repository.CocktailRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetDrinkDetail extends SingleUseCase<List<CocktailDetail>, GetDrinkDetail.Params> {
    private final CocktailRepository alcoholicRepository;

    @Inject
    GetDrinkDetail(CocktailRepository alcoholicRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.alcoholicRepository = alcoholicRepository;
    }

    @Override
    protected Single<List<CocktailDetail>> buildUseCaseObservable(Params params) {
        return alcoholicRepository.getDrinkDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}
