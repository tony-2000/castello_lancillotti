package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDAO
{
    public List<Recensione> doRetrieveAllReviews()
    {
        List<Recensione> list = new ArrayList<Recensione>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM recensione");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recensione p = new Recensione();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setCommento(rs.getString(3));
                p.setValutazione(rs.getInt(4));
                p.setDataRecensione(rs.getDate(5));
                p.setOrarioRecensione(rs.getTime(6));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Recensione> doRetrieveReviewsByKey(int idUtente, int idEvento) throws NumberFormatException
    {
        List<Recensione> list = new ArrayList<Recensione>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM recensione WHERE id_utente=? AND id_evento=?");
            ps.setString(1, Integer.toString(idUtente));
            ps.setString(2, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recensione p = new Recensione();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setCommento(rs.getString(3));
                p.setValutazione(rs.getInt(4));
                p.setDataRecensione(rs.getDate(5));
                p.setOrarioRecensione(rs.getTime(6));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Recensione> doRetrieveReviewsByEvent(int idEvento) throws NumberFormatException
    {
        List<Recensione> list = new ArrayList<Recensione>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM recensione WHERE id_evento=?");
            ps.setString(1, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recensione p = new Recensione();
                p.setIdUtente(rs.getInt(1));
                p.setIdEvento(rs.getInt(2));
                p.setCommento(rs.getString(3));
                p.setValutazione(rs.getInt(4));
                p.setDataRecensione(rs.getDate(5));
                p.setOrarioRecensione(rs.getTime(6));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Recensione temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO recensione (id_utente, id_evento, commento, " +
                                    "valutazione, data_recensione, orario_recensione) VALUES(?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, temp.getIdUtente());
            ps.setInt(2, temp.getIdEvento());
            ps.setString(3, temp.getCommento());
            ps.setInt(4, temp.getValutazione());
            ps.setDate(5, temp.getDataRecensione());
            ps.setTime(6, temp.getOrarioRecensione());

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
                    ("Delete FROM recensione WHERE id_utente=? and id_evento=?",
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

    public void doUpdate(Recensione temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE recensione SET commento=?,valutazione=?, " +
                            "data_recensione=?, orario_recensione=? WHERE id_utente=? AND id_evento=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, temp.getCommento());
            ps.setInt(2, temp.getValutazione());
            ps.setDate(3, temp.getDataRecensione());
            ps.setTime(4, temp.getOrarioRecensione());
            ps.setInt(5, temp.getIdUtente());
            ps.setInt(6, temp.getIdEvento());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
