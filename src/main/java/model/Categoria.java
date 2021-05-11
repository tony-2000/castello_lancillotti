package model;

public class Categoria
{
    private int idCategoria;
    private String nome;

    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public void setNome(String nome) { this.nome=nome;}

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public String getNome() {
        return this.nome;
    }

}
