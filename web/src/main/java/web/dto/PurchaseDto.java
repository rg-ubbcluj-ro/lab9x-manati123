package web.dto;
import core.domain.Client;
import core.domain.ClientDroidPrimaryKey;
import core.domain.Droid;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseDto extends Dto<ClientDroidPrimaryKey> {
    private Client client;
    private Droid droid;
    private double totalPrice;
}
