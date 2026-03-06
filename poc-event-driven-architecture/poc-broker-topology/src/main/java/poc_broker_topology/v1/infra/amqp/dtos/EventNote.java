package poc_broker_topology.v1.infra.amqp.dtos;

import lombok.Builder;

@Builder
public record EventNote(String noteId, String title, String content) {
}
