package com.streampro.data.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class MockInterceptor_Factory implements Factory<MockInterceptor> {
  @Override
  public MockInterceptor get() {
    return newInstance();
  }

  public static MockInterceptor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MockInterceptor newInstance() {
    return new MockInterceptor();
  }

  private static final class InstanceHolder {
    private static final MockInterceptor_Factory INSTANCE = new MockInterceptor_Factory();
  }
}
