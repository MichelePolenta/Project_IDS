package it.unicam.cs.ids2324.project.Model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContributorAut extends Persona {

    public ContributorAut(String nome, String mail, String password,Comune citta, String dataDiNascita) throws Exception{
        this.controlloCredenziali(mail, password);
        this.nome = nome;
        this.mail = mail;
        this.password = password;
        this.citta = citta;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDiNascita = LocalDate.parse(dataDiNascita, formatter);
        this.codice = generaCodice(Ruolo.CONTRAUT, this.citta.getNome());
    }

    public boolean inserimento(PuntoLogico puntoDiRilievo){
        return false;
    }

    public boolean inserimento(double itinerario){
        return false;
    }

    public boolean modifica(PuntoLogico puntoDiRilievo){
        return false;
    }

    public boolean modifica(double itinerario){
        return false;
    }

    @Override
    public Comune getCitta() {
        return this.citta;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String password() {
        return this.password;
    }

    @Override
    public String getCodice() {
        return this.codice;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

    @Override
    public LocalDate getDataDiNascita() {
        return this.dataDiNascita;
    }

    
}