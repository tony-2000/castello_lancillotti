package model;

public class Categoria
{
    private int idCategoria;
    private String nome;
    private String linkImmagine;

    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public void setNome(String nome) { this.nome=nome;}

    public void setLinkImmagine(String linkImmagine) { this.linkImmagine=linkImmagine;}

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLinkImmagine() {
        return this.linkImmagine;
    }

}
