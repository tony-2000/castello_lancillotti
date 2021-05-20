package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class DataDAO {
    public List<Data> doRetrieveAllDates() {
        List<Data> list = new ArrayList<Data>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM data");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data p = new Data();
                p.setData(rs.getDate(1));
                p.setIdEvento(rs.getInt(2));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Data> doRetrieveDatesByKey(Date data, int id) throws NumberFormatException {
        List<Data> list = new ArrayList<Data>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM data WHERE data=? AND id_evento=?");
            ps.setString(1, data.toString());
            ps.setString(2, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data p = new Data();
                p.setData(rs.getDate(1));
                p.setIdEvento(rs.getInt(2));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Data> doRetrieveDatesByEvent(int id) throws NumberFormatException {
        List<Data> list = new ArrayList<Data>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM data WHERE id_evento=?");
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data p = new Data();
                p.setData(rs.getDate(1));
                p.setIdEvento(rs.getInt(2));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Data date) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO data (data, id_evento) VALUES(?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, date.getData());
            ps.setInt(2, date.getIdEvento());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Date data, int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM data WHERE data =? and id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, data);
            ps.setInt(2, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
