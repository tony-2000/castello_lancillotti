package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente
{
    private int idUtente;
    private String nome;
    private String cognome;
    private boolean amministratore;
    private String telefono;
    private String mail;
    private String nomeUtente;
    private String password;



    public void setIdUtente(int idUtente) { this.idUtente = idUtente; }

    public void setNome(String nome) { this.nome=nome;}

    public void setCognome(String cognome) { this.cognome=cognome;}

    public void setAmministratore(boolean amministratore) { this.amministratore=amministratore;}

    public void setTelefono(String telefono) { this.telefono=telefono;}

    public void setMail(String mail) { this.mail=mail;}

    public void setNomeUtente(String nomeUtente) { this.nomeUtente=nomeUtente;}

    public void setPassword(String password) { this.password=password;}


    public int getIdUtente() { return this.idUtente; }

    public String getNome() { return this.nome; }

    public String getCognome() {
        return this.cognome;
    }

    public boolean isAmministratore() {
        return this.amministratore;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getMail() {
        return this.mail;
    }

    public String getNomeUtente() {
        return this.nomeUtente;
    }

    public String getPassword() {
        return this.password;
    }



    public void setPasswordHash(String password)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new BigInteger(1, digest.digest()));
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }


}



