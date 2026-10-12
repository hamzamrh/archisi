# Stratégie de fetch et de cascade — AutoLoc (Atelier 2)

## Choix par association

| Association | Côté propriétaire | Fetch | Cascade | Justification |
|---|---|---|---|---|
| Contrat → Paiement | Paiement (`contrat`) | LAZY | ALL + orphanRemoval | Composition : un paiement n'existe que rattaché à son contrat. Supprimer le contrat supprime ses paiements ; retirer un paiement de la liste `paiements` le supprime en base. |
| Agence → Vehicule | Vehicule (`agence`) | LAZY | Aucune | Un véhicule survit à son agence (il peut être réaffecté). Charger une agence ne doit pas charger toute sa flotte. |
| Agence → Employe | Employe (`agence`) | LAZY | Aucune | Un employé a son propre cycle de vie (mutation, départ) ; supprimer une agence ne doit pas supprimer son personnel. La liste n'est chargée que si elle est consultée. |
| Vehicule ↔ Equipement | Vehicule (`@JoinTable vehicule_equipement`) | LAZY | Aucune | Équipements partagés entre plusieurs véhicules : supprimer un véhicule ne doit pas supprimer un équipement utilisé ailleurs. `Set` pour éviter les doublons dans la table de jointure. |
| Client → Reservation | Reservation (`client`) | LAZY | PERSIST | Enregistrer un nouveau client enregistre aussi ses nouvelles réservations. Pas de REMOVE : supprimer un client ne doit pas effacer l'historique des réservations, contrats et paiements. |
| Reservation → Vehicule | Reservation (`vehicule`) | LAZY | Aucune | Association unidirectionnelle : la réservation référence le véhicule loué, qui reste géré par la flotte de l'agence. |
| Reservation ↔ Contrat | Contrat (`reservation`) | LAZY | ALL (côté Reservation) | Le contrat concrétise une réservation et n'a pas de sens sans elle : sauvegarder/supprimer la réservation se propage au contrat (puis, via Contrat → Paiement, aux paiements). |
| Vehicule → Maintenance | Maintenance (`vehicule`) | LAZY | PERSIST | Une maintenance ajoutée à un véhicule est enregistrée avec lui. Pas de REMOVE : l'historique d'entretien est conservé pour la traçabilité. |

## Règles appliquées

- **Fetch** : `@ManyToOne` et `@OneToOne` sont EAGER par défaut → forcés en LAZY pour éviter de charger toute la chaîne d'objets liés. `@OneToMany` et `@ManyToMany` restent LAZY.
- **Cascade** : uniquement quand l'enfant ne peut pas vivre sans son parent (composition) ; jamais de REMOVE sur des données métier à conserver (véhicules, employés, historiques).
- **mappedBy** : chaque côté inverse pointe vers l'attribut du côté propriétaire → aucune colonne ni table de jointure parasite.
- **Remarque `@OneToOne`** : sur le côté inverse (`Reservation.contrat`), Hibernate ne peut pas appliquer réellement le LAZY sans bytecode enhancement (il doit interroger la table `contrat` pour savoir si la valeur est nulle). C'est pourquoi la clé étrangère est portée par `Contrat`, côté où le LAZY est effectif.
- **Lombok** : pas de `@Data`. `@ToString.Exclude` sur tous les attributs d'association (évite le `StackOverflowError` et les `LazyInitializationException` dans `toString()`), `@JsonIgnore` sur les côtés inverses, `@Builder.Default` pour conserver l'initialisation des collections avec le builder.

## Schéma attendu (à vérifier dans MySQL)

| Table | Clé étrangère générée (convention Hibernate) |
|---|---|
| employee | `agence_id_agence` |
| vehicule | `agence_id_agence` |
| maintenance | `vehicule_id_vehicule` |
| reservation | `client_id_client`, `vehicule_id_vehicule` |
| contrat | `reservation_id_reservation` (unique) |
| paiment | `contrat_id_contrat` |
| vehicule_equipement | `vehicules_id_vehicule`, `equipements_id_equipement` |
