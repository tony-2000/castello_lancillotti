package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartecipareDAO
{
    public List<Partecipare> doRetrieveAllPartecipations()
    {
        List<Partecipare> list = new ArrayList<Partecipare>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM partecipare");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partecipare p = new Partecipare();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setAcquistato(rs.getBoolean(3));
                p.setQuantitaBiglietti(rs.getInt(4));
                p.setDataPartecipazione(rs.getDate(5));
                p.setOrarioPartecipazione(rs.getTime(6));
                p.setPrezzo(rs.getFloat(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Partecipare> doRetrievePartecipationsByKey(int idUtente, int idEvento) throws NumberFormatException
    {
        List<Partecipare> list = new ArrayList<Partecipare>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM partecipare WHERE id_utente=? AND id_evento=?");
            ps.setString(1, Integer.toString(idUtente));
            ps.setString(2, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partecipare p = new Partecipare();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setAcquistato(rs.getBoolean(3));
                p.setQuantitaBiglietti(rs.getInt(4));
                p.setDataPartecipazione(rs.getDate(5));
                p.setOrarioPartecipazione(rs.getTime(6));
                p.setPrezzo(rs.getFloat(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Partecipare temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO partecipare (id_utente, id_evento, acquistato, " +
                    "quantita_biglietti, data_partecipazione, orario_partecipazione,prezzo) VALUES(?,?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, temp.getIdUtente());
            ps.setInt(2, temp.getIdEvento());
            ps.setBoolean(3, temp.isAcquistato());
            ps.setInt(4, temp.getQuantitaBiglietti());
            ps.setDate(5, temp.getDataPartecipazione());
            ps.setTime(6, temp.getOrarioPartecipazione());
            ps.setFloat(7, temp.getPrezzo());

            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id, int id2)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM partecipare WHERE id_utente=? and id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, id2);
            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Partecipare temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE partecipare SET quantita_biglietti=?, " +
                            "data_partecipazione=?, orario_partecipazione=? WHERE id_utente=? AND id_evento=? AND prezzo=?",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, temp.getQuantitaBiglietti());
            ps.setDate(2, temp.getDataPartecipazione());
            ps.setTime(3, temp.getOrarioPartecipazione());
            ps.setInt(4, temp.getIdUtente());
            ps.setInt(5, temp.getIdEvento());
            ps.setFloat(6,temp.getPrezzo());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doBuy(Partecipare temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE partecipare SET acquistato=true WHERE id_utente=? AND id_evento=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, temp.getIdUtente());
            ps.setInt(2, temp.getIdEvento());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


    public List<Partecipare> doRetrieveShoppingCart(int idUtente) throws NumberFormatException
    {
        List<Partecipare> list = new ArrayList<Partecipare>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM partecipare WHERE id_utente=? AND acquistato=false");
            ps.setString(1, Integer.toString(idUtente));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partecipare p = new Partecipare();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setAcquistato(rs.getBoolean(3));
                p.setQuantitaBiglietti(rs.getInt(4));
                p.setDataPartecipazione(rs.getDate(5));
                p.setOrarioPartecipazione(rs.getTime(6));
                p.setPrezzo(rs.getFloat(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Partecipare> doRetrievePurchases(int idUtente) throws NumberFormatException
    {
        List<Partecipare> list = new ArrayList<Partecipare>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM partecipare WHERE id_utente=? AND acquistato=true");
            ps.setString(1, Integer.toString(idUtente));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partecipare p = new Partecipare();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setAcquistato(rs.getBoolean(3));
                p.setQuantitaBiglietti(rs.getInt(4));
                p.setDataPartecipazione(rs.getDate(5));
                p.setOrarioPartecipazione(rs.getTime(6));
                p.setPrezzo(rs.getFloat(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
