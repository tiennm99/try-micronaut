package com.miti99.test.listener;

import com.miti99.test.event.SimpleEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class SimpleListener {

  @EventListener
  public void onApplicationEvent(SimpleEvent event) {
    System.out.println("SimpleListener.onApplicationEvent");
  }
}
