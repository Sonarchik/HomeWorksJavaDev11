package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table
@Data
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    @Column
    private String id;

    @Column(columnDefinition = "VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1)")
    private String name;
}
