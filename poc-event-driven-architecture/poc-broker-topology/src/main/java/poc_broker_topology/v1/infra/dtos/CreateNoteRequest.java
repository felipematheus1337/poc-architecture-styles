package poc_broker_topology.v1.infra.dtos;

import lombok.Builder;

@Builder
public record CreateNoteRequest(String title, String content) {
}
