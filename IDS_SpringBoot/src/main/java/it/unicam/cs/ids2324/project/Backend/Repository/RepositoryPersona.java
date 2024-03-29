package it.unicam.cs.ids2324.project.Backend.Repository;

import it.unicam.cs.ids2324.project.Backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia che rappresenta una risorsa per la gestione delle operazioni CRUD su entità Persona.
 * Estende JpaRepository fornito da Spring Data JPA per le operazioni di persistenza.
 * Utilizzata per interagire con la tabella "Persona" nel database.
 */
@Repository
public interface RepositoryPersona extends JpaRepository<Persona, String> {
}
