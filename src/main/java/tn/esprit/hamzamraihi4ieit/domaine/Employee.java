package tn.esprit.hamzamraihi4ieit.domaine;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee ;
    private String nom ;
    private String prenom ;
    private String role ;
    @Enumerated(value = EnumType.STRING)
    private RoleEmployee statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Agence agence;
}
