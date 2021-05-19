package model;

import java.sql.Date;
import java.sql.Time;

public class Recensione {


        private int idUtente;
        private int idEvento;
        private String commento;
        private int valutazione;
        private Date dataRecensione;
        private Time orarioRecensione;


        public void setIdUtente(int idUtente) { this.idUtente = idUtente; }

        public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

        public void setCommento(String commento) { this.commento = commento; }

        public void setValutazione(int valutazione) { this.valutazione = valutazione; }

        public void setDataRecensione(Date dataRecensione) { this.dataRecensione = dataRecensione; }

        public void setOrarioRecensione(Time orarioRecensione) { this.orarioRecensione = orarioRecensione; }




        public int getIdUtente() { return this.idUtente; }

        public int getIdEvento() { return this.idEvento; }

        public String getCommento() { return this.commento; }

        public int getValutazione() { return this.valutazione; }

        public Date getDataRecensione() { return this.dataRecensione; }

        public Time getOrarioRecensione() { return this.orarioRecensione; }

}