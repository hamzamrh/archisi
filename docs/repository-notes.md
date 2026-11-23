# Note de synthèse — Couche Repository (Atelier 3)

## 1. Choix et justification des interfaces Repository

Toutes les interfaces étendent `JpaRepository<Entité, TypeId>` afin de bénéficier :
- des opérations CRUD de base (`save`, `findById`, `findAll`, `deleteById`) ;
- de méthodes qui retournent directement des `List` (via `ListCrudRepository`) au lieu de simples `Iterable` ;
- du tri et de la pagination (`PagingAndSortingRepository`) ;
- des méthodes propres à JPA : `flush()`, `saveAndFlush()`, `deleteAllInBatch()`.

Le second paramètre générique correspond au type de l'identifiant `@Id` de l'entité.

| Interface | Étend | Justification |
|---|---|---|
| `IAgenceRepository` | `JpaRepository<Agence, Long>` | CRUD complet, listing direct en `List`, tri et pagination des agences. |
| `IClientRepository` | `JpaRepository<Client, Long>` | CRUD complet, recherche par identifiant et gestion de la liste des clients. |
| `IContratRepository` | `JpaRepository<Contrat, Long>` | CRUD complet sur les contrats, `saveAndFlush` et pagination disponibles. |
| `IEmployeeRepository` | `JpaRepository<Employee, Long>` | CRUD complet sur les employés, collections manipulées en `List`. |
| `IEquipementsRepository` | `JpaRepository<Equipements, Long>` | CRUD complet pour les équipements des véhicules. |
| `IMaintenanceRepository` | `JpaRepository<Maintenance, Integer>` | CRUD complet sur l'historique des maintenances (identifiant de type `int`). |
| `IPaimentRepository` | `JpaRepository<Paiment, Long>` | Lecture et gestion des paiements liés aux contrats. |
| `IReservationRepository` | `JpaRepository<Reservation, Integer>` | CRUD complet sur les réservations (identifiant de type `int`), pagination. |
| `IVehiculeRepository` | `JpaRepository<vehicule, Long>` | CRUD complet sur le parc automobile, tri et pagination. |

---

## 2. Anomalies SonarQube for IDE (SonarLint) et corrections

| Anomalie | Règle / explication | Correction apportée |
|---|---|---|
| Imports inutilisés (`java:S1128`) | Des imports superflus alourdissent le code et masquent les vraies dépendances. | Suppression des imports inutilisés dans les repositories et les services. |
| Injection par champ déconseillée (`java:S6813`) | `@Autowired` sur un attribut empêche l'immutabilité et complique les tests unitaires. | Injection par constructeur avec Lombok `@RequiredArgsConstructor` et des champs `private final` dans les 9 services. |
| `@Data` sur une entité JPA (`java:S6856`) | `@Data` génère `equals`, `hashCode` et `toString`, qui peuvent déclencher des chargements LAZY involontaires ou des boucles infinies (`StackOverflowError`). | Annotations ciblées `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder`, `@ToString` avec `@ToString.Exclude` sur les associations. |

---

## 3. Remarques sur l'exécution

- Au démarrage, Spring Data JPA détecte les 9 interfaces : `Found 9 JPA repository interfaces`.
- Les couches Service et Controller couvrent les 9 entités, ce qui permet de tester tout le CRUD en REST (Swagger UI / Postman).
