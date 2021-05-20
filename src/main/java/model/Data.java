package model;

import java.sql.Date;

public class Data
{
    private Date data;
    private int idEvento;


    public void setData(Date data) { this.data = data; }

    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }



    public Date getData() {
        return this.data;
    }

    public int getIdEvento() { return this.idEvento; }



}
