package model;

import java.sql.Date;

public class Data
{
    private Date dataInizio;
    private int idEvento;
    private Date dataFine;


    public void setDataInizio(Date dataInizio) { this.dataInizio = dataInizio; }

    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

    public void setDataFine(Date dataFine) { this.dataFine = dataFine; }


    public Date getDataInizio() {
        return this.dataInizio;
    }

    public int getIdEvento() { return this.idEvento; }

    public Date getDataFine() {
        return this.dataFine;
    }


}
