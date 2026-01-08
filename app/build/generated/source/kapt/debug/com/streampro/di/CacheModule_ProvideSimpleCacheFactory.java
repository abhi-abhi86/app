package com.streampro.di;

import android.content.Context;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.cache.SimpleCache;
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
public final class CacheModule_ProvideSimpleCacheFactory implements Factory<SimpleCache> {
  private final Provider<Context> contextProvider;

  private final Provider<DatabaseProvider> databaseProvider;

  public CacheModule_ProvideSimpleCacheFactory(Provider<Context> contextProvider,
      Provider<DatabaseProvider> databaseProvider) {
    this.contextProvider = contextProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SimpleCache get() {
    return provideSimpleCache(contextProvider.get(), databaseProvider.get());
  }

  public static CacheModule_ProvideSimpleCacheFactory create(Provider<Context> contextProvider,
      Provider<DatabaseProvider> databaseProvider) {
    return new CacheModule_ProvideSimpleCacheFactory(contextProvider, databaseProvider);
  }

  public static SimpleCache provideSimpleCache(Context context, DatabaseProvider databaseProvider) {
    return Preconditions.checkNotNullFromProvides(CacheModule.INSTANCE.provideSimpleCache(context, databaseProvider));
  }
}
