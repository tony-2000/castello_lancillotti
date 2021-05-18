package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO
{
    public List<Evento> doRetrieveAllEvents()
    {
        List<Evento> list = new ArrayList<Evento>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM evento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evento p = new Evento();
                p.setIdEvento(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setLinkImmagine(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setNome(rs.getString(6));
                p.setPostiDisponibili(rs.getInt(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Evento doRetrieveEventsByKey(int id) throws NumberFormatException
    {
        try (Connection con = ConPool.getConnection())
        {
            Evento p = new Evento();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM evento WHERE id_evento=?");
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {

                p.setIdEvento(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setLinkImmagine(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setNome(rs.getString(6));
                p.setPostiDisponibili(rs.getInt(7));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Evento temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO evento (id_categoria, link_immagine, descrizione, prezzo, nome, posti_disponibili) " +
                                    "VALUES(?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, temp.getIdCategoria());
            ps.setString(2, temp.getLinkImmagine());
            ps.setString(3, temp.getDescrizione());
            ps.setFloat(4, temp.getPrezzo());
            ps.setString(5, temp.getNome());
            ps.setInt(6, temp.getPostiDisponibili());

            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM evento WHERE id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Evento temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE evento SET link_immagine=?, " +
                            "descrizione=?, prezzo=?, nome=?, posti_disponibili=?, id_categoria=? WHERE id_evento=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, temp.getLinkImmagine());
            ps.setString(2, temp.getDescrizione());
            ps.setFloat(3, temp.getPrezzo());
            ps.setString(4, temp.getNome());
            ps.setInt(5, temp.getPostiDisponibili());
            ps.setInt(6,temp.getIdCategoria());
            ps.setInt(7, temp.getIdEvento());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Evento> doRetrieveEventsByCatId(int id) throws NumberFormatException
    {
        List<Evento> list = new ArrayList<Evento>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM evento WHERE id_categoria=?");
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evento p = new Evento();
                p.setIdEvento(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setLinkImmagine(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setNome(rs.getString(6));
                p.setPostiDisponibili(rs.getInt(7));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
