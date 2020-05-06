package ir.ac.sbu.hodhod.hodhod.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name= "roles")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
