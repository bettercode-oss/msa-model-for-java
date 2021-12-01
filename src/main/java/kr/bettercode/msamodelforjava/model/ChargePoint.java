package kr.bettercode.msamodelforjava.model;

import java.util.List;
import java.util.Objects;

public class ChargePoint {

  private Long id;
  private String vendor;
  private String model;
  private ChargePointStatus status;
  private List<Transaction> transactions;

  public ChargePoint() {}

  public ChargePoint(Long id, String vendor, String model, ChargePointStatus status, List<Transaction> transactions) {
    this.id = id;
    this.vendor = vendor;
    this.model = model;
    this.status = status;
    this.transactions = transactions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public ChargePointStatus getStatus() {
    return status;
  }

  public void setStatus(ChargePointStatus status) {
    this.status = status;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargePoint that = (ChargePoint) o;
    return Objects.equals(getId(), that.getId()) && Objects.equals(getVendor(), that.getVendor())
        && Objects.equals(getModel(), that.getModel()) && getStatus() == that.getStatus();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getVendor(), getModel(), getStatus());
  }

  @Override
  public String toString() {
    return "ChargePoint{" +
        "id=" + id +
        ", vendor='" + vendor + '\'' +
        ", model='" + model + '\'' +
        ", status=" + status +
        '}';
  }
}
