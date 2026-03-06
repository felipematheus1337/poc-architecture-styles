package poc_broker_topology.v1.infra.exceptions;

public class ConsumerStreamException extends RuntimeException {

    public ConsumerStreamException() {
    }

    public ConsumerStreamException(String message) {
        super(message);
    }
}
