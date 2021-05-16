package model;

public class CartElement extends Partecipare
{
    private String nome;

    private String link;

    public void setNome(String nome) { this.nome=nome;}

    public String getNome() {
        return this.nome;
    }

    public void setLink(String link) { this.link=link;}

    public String getLink() {
        return this.link;
    }
}
