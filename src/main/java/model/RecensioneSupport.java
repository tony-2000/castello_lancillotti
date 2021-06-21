package model;

/*Classe di supporto a Recensione che aggiunge il nome dell'autore*/

public class RecensioneSupport extends Recensione
{
    private String nome;

    public void setNome(String nome) { this.nome=nome;}

    public String getNome() {
        return this.nome;
    }


}
