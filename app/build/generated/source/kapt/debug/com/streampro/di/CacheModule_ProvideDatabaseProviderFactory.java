package com.streampro.di;

import android.content.Context;
import androidx.media3.database.DatabaseProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class CacheModule_ProvideDatabaseProviderFactory implements Factory<DatabaseProvider> {
  private final Provider<Context> contextProvider;

  public CacheModule_ProvideDatabaseProviderFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DatabaseProvider get() {
    return provideDatabaseProvider(contextProvider.get());
  }

  public static CacheModule_ProvideDatabaseProviderFactory create(
      Provider<Context> contextProvider) {
    return new CacheModule_ProvideDatabaseProviderFactory(contextProvider);
  }

  public static DatabaseProvider provideDatabaseProvider(Context context) {
    return Preconditions.checkNotNullFromProvides(CacheModule.INSTANCE.provideDatabaseProvider(context));
  }
}
