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
                p.setDataInizio(rs.getDate(2));
                p.setIdEvento(rs.getInt(3));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Orario> doRetrieveTimesByKey(Time ora, Date dataInizio, int idEvento) throws NumberFormatException {
        List<Orario> list = new ArrayList<Orario>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orario WHERE ora=? AND data_inizio=? AND id_evento=?");
            ps.setString(1, ora.toString());
            ps.setString(2, dataInizio.toString());
            ps.setString(3, Integer.toString(idEvento));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orario p = new Orario();
                p.setOra(rs.getTime(1));
                p.setDataInizio(rs.getDate(2));
                p.setIdEvento(rs.getInt(3));
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
                    ("INSERT INTO orario (ora, data_inizio, id_evento) VALUES(?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, temp.getOra());
            ps.setDate(2, temp.getDataInizio());
            ps.setInt(3, temp.getIdEvento());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Time ora, Date dataInizio, int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM orario WHERE ora = ? and data_inizio=? and id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, ora);
            ps.setDate(2, dataInizio);
            ps.setInt(3, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

   // public void doUpdate(Orario temp )  NON IMPLEMENTABILE