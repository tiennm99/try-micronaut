package com.miti99.test.publisher;

import com.miti99.test.event.GenericEvent;
import com.miti99.test.event.SimpleEvent;
import com.miti99.test.type.B;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/Simple")
public class SimplePublisher {

  private final ApplicationEventPublisher<SimpleEvent> eventPublisher;

  public SimplePublisher(ApplicationEventPublisher<SimpleEvent> eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @Get
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    SimpleEvent event = new SimpleEvent();
    eventPublisher.publishEvent(event);
    return "fired simple event";
  }
}
