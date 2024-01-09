package at.tgm.MOMReceiver;

import javax.jms.JMSException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tradearea.model.WarehouseData;

@RestController
public class Controller {
    private List<WarehouseData> warehouseData;
    private MOMReceiver receiver;

    public Controller() throws JMSException {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        this.receiver = new MOMReceiver();
    }

    @GetMapping("/")
    public List<WarehouseData> getWarehouseses() throws JMSException {
        return receiver.getData();
    }
}
