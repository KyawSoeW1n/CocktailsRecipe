package com.kurio.cocktail.domain.interactor;

import com.kurio.cocktail.domain.executor.PostExecutionThread;

import io.reactivex.Flowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Abstract class for a Observable Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 * <p>
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class FlowableUseCase<T, Params> {
    private final PostExecutionThread postExecutionThread;

    protected FlowableUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Flowable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableSubscriber disposableSubscriber, Params params) {
        final Flowable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler());
        observable.subscribeWith(disposableSubscriber);
    }
}