package ir.ac.sbu.hodhod.hodhod.entity;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    //    @RequiredTypes()
    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @NonNull
    private String fullName;

    @NonNull
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();


}
