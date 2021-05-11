package model;

import java.sql.Date;
import java.sql.Time;

public class Partecipare
{
    private int idUtente;
    private int idEvento;
    private boolean acquistato;
    private int quantitaBiglietti;
    private Date dataPartecipazione;
    private Time orarioPartecipazione;
    private float prezzo;


    public void setIdUtente(int idUtente) { this.idUtente = idUtente; }

    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

    public void setAcquistato(boolean acquistato) { this.acquistato = acquistato; }

    public void setQuantitaBiglietti(int quantitaBiglietti) { this.quantitaBiglietti = quantitaBiglietti; }

    public void setDataPartecipazione(Date dataPartecipazione) { this.dataPartecipazione = dataPartecipazione; }

    public void setOrarioPartecipazione(Time orarioPartecipazione) { this.orarioPartecipazione = orarioPartecipazione; }

    public void setPrezzo(float prezzo) { this.prezzo = prezzo;}





    public int getIdUtente() { return this.idUtente; }

    public int getIdEvento() { return this.idEvento; }

    public boolean isAcquistato() { return this.acquistato; }

    public int getQuantitaBiglietti() { return this.quantitaBiglietti; }

    public Date getDataPartecipazione() { return this.dataPartecipazione; }

    public Time getOrarioPartecipazione() { return this.orarioPartecipazione; }

    public float getPrezzo() { return this.prezzo; }

}
