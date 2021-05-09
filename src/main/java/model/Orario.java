package model;

import java.sql.Date;
import java.sql.Time;

public class Orario
{
    private Time ora;
    private Date dataInizio;
    private int idEvento;




    public void setOra(Time ora) { this.ora=ora;}

    public void setDataInizio(Date dataInizio) { this.dataInizio=dataInizio;}

    public void setIdEvento(int idEvento) { this.idEvento=idEvento;}



    public Time getOra() { return this.ora; }

    public Date getDataInizio() { return this.dataInizio; }

    public int getIdEvento() { return this.idEvento; }


}
