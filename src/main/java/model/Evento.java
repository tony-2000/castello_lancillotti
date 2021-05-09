package model;

import org.apache.taglibs.standard.lang.jstl.StringLiteral;

public class Evento
{
    private int idEvento;
    private int idCategoria;
    private String linkImmagine;
    private String descrizione;
    private float prezzo;
    private String nome;
    private int postiDisponibili;

    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public void setLinkImmagine(String linkImmagine) { this.linkImmagine=linkImmagine;}

    public void setDescrizione(String descrizione) { this.descrizione=descrizione;}

    public void setPrezzo(float prezzo) { this.prezzo=prezzo;}

    public void setNome(String nome) { this.nome=nome;}

    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili=postiDisponibili;}




    public int getIdEvento() {
        return this.idEvento;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public String getLinkImmagine() {
        return this.linkImmagine;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public float getPrezzo() {
        return this.prezzo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPostiDisponibili() { return this.postiDisponibili; }









}
