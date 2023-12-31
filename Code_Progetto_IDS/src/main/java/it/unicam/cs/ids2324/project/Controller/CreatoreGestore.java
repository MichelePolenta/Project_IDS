package it.unicam.cs.ids2324.project.Controller;


import it.unicam.cs.ids2324.project.Model.Comune;
import it.unicam.cs.ids2324.project.Model.Gestore;
import it.unicam.cs.ids2324.project.Model.Persona;

public class CreatoreGestore extends CreatorePersona {

    public Persona creaAttore(String nome, String cognome,String mail, String password, String citta, String dataDiNascita)throws Exception{
       return new Gestore(nome, cognome,mail, password, new Comune(citta), dataDiNascita);
    }
    
}
