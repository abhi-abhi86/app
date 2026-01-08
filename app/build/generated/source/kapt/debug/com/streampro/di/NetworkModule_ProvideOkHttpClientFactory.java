package com.streampro.di;

import com.streampro.data.api.AuthInterceptor;
import com.streampro.data.api.MockInterceptor;
import com.streampro.data.api.TokenAuthenticator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<AuthInterceptor> authInterceptorProvider;

  private final Provider<TokenAuthenticator> tokenAuthenticatorProvider;

  private final Provider<MockInterceptor> mockInterceptorProvider;

  private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;

  public NetworkModule_ProvideOkHttpClientFactory(Provider<AuthInterceptor> authInterceptorProvider,
      Provider<TokenAuthenticator> tokenAuthenticatorProvider,
      Provider<MockInterceptor> mockInterceptorProvider,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
    this.authInterceptorProvider = authInterceptorProvider;
    this.tokenAuthenticatorProvider = tokenAuthenticatorProvider;
    this.mockInterceptorProvider = mockInterceptorProvider;
    this.loggingInterceptorProvider = loggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(authInterceptorProvider.get(), tokenAuthenticatorProvider.get(), mockInterceptorProvider.get(), loggingInterceptorProvider.get());
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(
      Provider<AuthInterceptor> authInterceptorProvider,
      Provider<TokenAuthenticator> tokenAuthenticatorProvider,
      Provider<MockInterceptor> mockInterceptorProvider,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpClientFactory(authInterceptorProvider, tokenAuthenticatorProvider, mockInterceptorProvider, loggingInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(AuthInterceptor authInterceptor,
      TokenAuthenticator tokenAuthenticator, MockInterceptor mockInterceptor,
      HttpLoggingInterceptor loggingInterceptor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideOkHttpClient(authInterceptor, tokenAuthenticator, mockInterceptor, loggingInterceptor));
  }
}
