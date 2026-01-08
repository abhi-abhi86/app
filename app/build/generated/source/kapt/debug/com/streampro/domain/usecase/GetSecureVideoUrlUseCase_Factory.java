package com.streampro.domain.usecase;

import com.streampro.domain.repository.MovieRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class GetSecureVideoUrlUseCase_Factory implements Factory<GetSecureVideoUrlUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public GetSecureVideoUrlUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetSecureVideoUrlUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetSecureVideoUrlUseCase_Factory create(
      Provider<MovieRepository> repositoryProvider) {
    return new GetSecureVideoUrlUseCase_Factory(repositoryProvider);
  }

  public static GetSecureVideoUrlUseCase newInstance(MovieRepository repository) {
    return new GetSecureVideoUrlUseCase(repository);
  }
}
