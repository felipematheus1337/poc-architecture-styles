package poc_broker_topology.v1.infra.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eventId", unique = true)
    private String eventId;

    private String consumer;

    @Column(name = "indexed_text")
    private String indexedText;

    private LocalDateTime processedAt;
}
