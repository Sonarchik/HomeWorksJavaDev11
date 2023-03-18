package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "FROM_PLANET_ID", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "TO_PLANET_ID", nullable = false)
    private Planet toPlanet;
}
