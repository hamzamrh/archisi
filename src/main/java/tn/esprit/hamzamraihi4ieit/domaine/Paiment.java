package tn.esprit.hamzamraihi4ieit.domaine;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPaiment;
    private BigDecimal montant;
    private LocalDate datePaiment;
    @Enumerated(value = EnumType.STRING)
    private ModePaiment modePaiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Contrat contrat;
}
