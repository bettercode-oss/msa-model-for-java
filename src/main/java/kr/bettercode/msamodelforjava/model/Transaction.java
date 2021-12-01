package kr.bettercode.msamodelforjava.model;

import java.util.List;
import java.util.Objects;

public class Transaction {

  private Long id;
  private String chargingConnector;
  private TransactionStatus status;
  private List<TransactionEvent> transactionEvents;

  public Transaction() {}

  public Transaction(Long id, String chargingConnector, TransactionStatus status,
      List<TransactionEvent> transactionEvents) {
    this.id = id;
    this.chargingConnector = chargingConnector;
    this.status = status;
    this.transactionEvents = transactionEvents;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getChargingConnector() {
    return chargingConnector;
  }

  public void setChargingConnector(String chargingConnector) {
    this.chargingConnector = chargingConnector;
  }

  public TransactionStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionStatus status) {
    this.status = status;
  }

  public List<TransactionEvent> getTransactionEvents() {
    return transactionEvents;
  }

  public void setTransactionEvents(List<TransactionEvent> transactionEvents) {
    this.transactionEvents = transactionEvents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction that = (Transaction) o;
    return Objects.equals(getId(), that.getId()) && Objects.equals(getChargingConnector(),
        that.getChargingConnector()) && getStatus() == that.getStatus();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getChargingConnector(), getStatus());
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "id=" + id +
        ", chargingConnector='" + chargingConnector + '\'' +
        ", status=" + status +
        '}';
  }
}
