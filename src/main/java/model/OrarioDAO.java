package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrarioDAO {
    public List<Orario> doRetrieveAllTimes() {
        List<Orario> list = new ArrayList<Orario>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orario p = new Orario();
                p.setOra(rs.getTime(1));
                p.setData(rs.getDate(2));
                p.setIdEvento(rs.getInt(3));
                p.setPostiDisponibili(rs.getInt(4));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Orario doRetrieveTimesByKey(Time ora, Date data, int idEvento) throws NumberFormatException {
        Orario temp=new Orario();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orario WHERE ora=? AND data=? AND id_evento=?");
            ps.setString(1, ora.toString());
            ps.setString(2, data.toString());
            ps.setString(3, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                temp.setOra(rs.getTime(1));
                temp.setData(rs.getDate(2));
                temp.setIdEvento(rs.getInt(3));
                temp.setPostiDisponibili(rs.getInt(4));
            }
            return temp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Orario> doRetrieveTimesByEventDate(Date data, int idEvento) throws NumberFormatException {
        List<Orario> list = new ArrayList<Orario>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orario WHERE data=? AND id_evento=?");
            ps.setString(1, data.toString());
            ps.setString(2, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orario p = new Orario();
                p.setOra(rs.getTime(1));
                p.setData(rs.getDate(2));
                p.setIdEvento(rs.getInt(3));
                p.setPostiDisponibili(rs.getInt(4));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Orario temp) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO orario (ora, data, id_evento,posti_disponibili) VALUES(?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, temp.getOra());
            ps.setDate(2, temp.getData());
            ps.setInt(3, temp.getIdEvento());
          ps.setInt(4,temp.getPostiDisponibili());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Time ora, Date data, int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM orario WHERE ora = ? and data=? and id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, ora);
            ps.setDate(2, data);
            ps.setInt(3, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Orario temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE orario SET posti_disponibili=? " +
                            "WHERE id_evento=? AND data=? AND ora=? ",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, temp.getPostiDisponibili());
            ps.setInt(2, temp.getIdEvento());
            ps.setDate(3, temp.getData());
            ps.setTime(4, temp.getOra());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

