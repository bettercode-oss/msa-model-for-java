package kr.bettercode.msamodelforjava.model;

import java.util.Objects;

public class Transactions {

  private Long id;
  private String chargingConnector;
  private TransactionStatus status;
  private Long chargePointId;

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

  public Long getChargePointId() {
    return chargePointId;
  }

  public void setChargePointId(Long chargePointId) {
    this.chargePointId = chargePointId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transactions that = (Transactions) o;
    return Objects.equals(getId(), that.getId()) && Objects.equals(getChargingConnector(), that.getChargingConnector())
        && getStatus() == that.getStatus() && Objects.equals(getChargePointId(), that.getChargePointId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getChargingConnector(), getStatus(), getChargePointId());
  }

  @Override
  public String toString() {
    return "Transactions{" +
        "id=" + id +
        ", chargingConnector='" + chargingConnector + '\'' +
        ", status=" + status +
        ", chargePointId=" + chargePointId +
        '}';
  }
}
