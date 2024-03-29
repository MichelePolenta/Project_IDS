package it.unicam.cs.ids2324.project.Backend.Service;

import it.unicam.cs.ids2324.project.Backend.Exception.CredenzialiException;
import it.unicam.cs.ids2324.project.Backend.Util.JWT.DTOManager;
import it.unicam.cs.ids2324.project.Backend.Util.JWT.PersonaManager;
import it.unicam.cs.ids2324.project.Backend.Model.Persona;
import it.unicam.cs.ids2324.project.Backend.Repository.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service che rappresenta le operazioni relative alle persone, inclusa la gestione delle credenziali, la conversione
 * in DTO (Data Transfer Object) e l'implementazione del servizio UserDetailsService per l'autenticazione.
 * Interagisce con la risorsa ResourcePersona per accedere al database.
 */
@Service
public class PersonaService implements UserDetailsService {



    private final RepositoryPersona repositoryPersona;

    public PersonaService(RepositoryPersona repositoryPersona) {
         this.repositoryPersona = repositoryPersona;
    }

    public Optional<Persona> getPersona(String mail) {
        return repositoryPersona.findById(mail);
    }

    public Persona addPersona(Persona persona) throws Exception{
        if (persona.getPassword() == null || persona.getNome() == null || persona.getMail() == null || persona.getComune() == null || persona.getCognome() == null || persona.getDataDiNascita() == null)
            throw new CredenzialiException("Tutte le credenziali devono essere inserite correttamente");
        return this.repositoryPersona.save(persona);
    }

    public DTOManager convertToDTO(Optional<Persona> persona){
        return new DTOManager(persona.get().getNome(), persona.get().getCognome(),persona.get().getDataDiNascita(),
                persona.get().getMail(), persona.get().getPassword(), persona.get().getRuolo());
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Persona> persona = this.repositoryPersona.findById(mail);
        if (!persona.isPresent()) {
            throw new UsernameNotFoundException("Mail errata o inesistente: " + mail);
        }
        return new PersonaManager(persona.get());
    }


}
