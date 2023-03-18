package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)")
    private String name;
}
