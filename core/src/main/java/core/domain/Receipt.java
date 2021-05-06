package core.domain;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Receipt extends BaseEntity<Long>  {

    private Long purchaseID;
    double totalPrice;

    /**
     * @return
     */
    public Long getPurchaseID() {
        return purchaseID;
    }

    /**
     * @param purchaseID Long
     */
    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }

    /**
     * @return double
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice double
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    /**
     * @param purchaseID purchid
     * @param totalPrice ttlprice
     */
    public Receipt(Long purchaseID, double totalPrice) {
        this.purchaseID = purchaseID;
        this.totalPrice = totalPrice;
    }

    public Receipt(Long id, Long purchaseID, double totalPrice) {
        this.setId(id);
        this.purchaseID = purchaseID;
        this.totalPrice = totalPrice;
    }

    public Receipt() {
        this.purchaseID = 0L;
        this.totalPrice = 0L;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Double.compare(receipt.totalPrice, totalPrice) == 0 && purchaseID.equals(receipt.purchaseID);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(purchaseID, totalPrice);
    }

    /**
     * @return String
     */

    @Override
    public String toString() {
        return "Receipt{" +
                "purchaseID=" + purchaseID +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
