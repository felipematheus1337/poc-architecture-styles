package poc_broker_topology.v1.infra.amqp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteEventDto {

    private String eventId;
    private String eventType;
    private LocalDateTime timestamp;
    private String version;
    private EventNote data;
}
