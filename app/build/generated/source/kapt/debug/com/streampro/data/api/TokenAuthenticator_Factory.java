package com.streampro.data.api;

import com.streampro.data.local.TokenManager;
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
public final class TokenAuthenticator_Factory implements Factory<TokenAuthenticator> {
  private final Provider<TokenManager> tokenManagerProvider;

  private final Provider<ApiService> apiServiceProvider;

  public TokenAuthenticator_Factory(Provider<TokenManager> tokenManagerProvider,
      Provider<ApiService> apiServiceProvider) {
    this.tokenManagerProvider = tokenManagerProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public TokenAuthenticator get() {
    return newInstance(tokenManagerProvider.get(), apiServiceProvider);
  }

  public static TokenAuthenticator_Factory create(Provider<TokenManager> tokenManagerProvider,
      Provider<ApiService> apiServiceProvider) {
    return new TokenAuthenticator_Factory(tokenManagerProvider, apiServiceProvider);
  }

  public static TokenAuthenticator newInstance(TokenManager tokenManager,
      Provider<ApiService> apiServiceProvider) {
    return new TokenAuthenticator(tokenManager, apiServiceProvider);
  }
}
