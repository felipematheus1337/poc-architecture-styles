package poc_broker_topology.v1.infra.exceptions;


public class ProducerStreamException extends RuntimeException {

    public ProducerStreamException(String message) {
        super(message);
    }

    public ProducerStreamException() {
    }
}
