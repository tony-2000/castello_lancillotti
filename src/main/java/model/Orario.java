package model;

import java.sql.Date;
import java.sql.Time;

public class Orario
{
    private Time ora;
    private Date data;
    private int idEvento;
    private int postiDisponibili;




    public void setOra(Time ora) { this.ora=ora;}

    public void setData(Date data) { this.data=data;}

    public void setIdEvento(int idEvento) { this.idEvento=idEvento;}

    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili=postiDisponibili;}



    public Time getOra() { return this.ora; }

    public Date getData() { return this.data; }

    public int getIdEvento() { return this.idEvento; }

    public int getPostiDisponibili() { return this.postiDisponibili; }


}
