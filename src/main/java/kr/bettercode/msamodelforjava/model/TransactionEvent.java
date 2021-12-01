package kr.bettercode.msamodelforjava.model;

import java.util.Objects;

public class TransactionEvent {

  private Long id;
  private EventType eventType;
  private String eventData; // JSON

  public TransactionEvent() {}

  public TransactionEvent(Long id, EventType eventType, String eventData) {
    this.id = id;
    this.eventType = eventType;
    this.eventData = eventData;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public String getEventData() {
    return eventData;
  }

  public void setEventData(String eventData) {
    this.eventData = eventData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionEvent that = (TransactionEvent) o;
    return Objects.equals(getId(), that.getId()) && getEventType() == that.getEventType()
        && Objects.equals(getEventData(), that.getEventData());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getEventType(), getEventData());
  }

  @Override
  public String toString() {
    return "TransactionEvents{" +
        "id=" + id +
        ", eventType=" + eventType +
        ", eventData='" + eventData + '\'' +
        '}';
  }
}
