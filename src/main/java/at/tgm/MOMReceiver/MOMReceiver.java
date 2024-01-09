package at.tgm.MOMReceiver;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import tradearea.model.WarehouseData;

import java.util.List;
import java.util.ArrayList;

import javax.jms.*;

public class MOMReceiver {

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "warehouse";
    private Connection connection = null;
    private Session session = null;
    private List<WarehouseData> data = new ArrayList<>();
    private MessageConsumer consumer = null;
    private Destination destination = null;

    public MOMReceiver() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
        connection = connectionFactory.createConnection();
        //connection.setClientID("MomReceiver");
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        destination = session.createQueue(subject);
        consumer = session.createConsumer(destination);

    }

    public List<WarehouseData> getData() {
        try {
            Message message = (Message) consumer.receiveNoWait();
            System.out.println(message);

            while (message != null) {
                System.out.println("Message received");
                message.acknowledge();
                ObjectMessage objms = (ObjectMessage) message;
                data.add((WarehouseData) objms.getObject());
                message = consumer.receiveNoWait();
            }
        }
        catch(JMSException e) {
            e.printStackTrace();
        }
        return data;
    }
}
