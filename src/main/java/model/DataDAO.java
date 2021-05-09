package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class DataDAO
{
    public List<Data> doRetrieveAllDates()
    {
        List<Data> list = new ArrayList<Data>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM data");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data p = new Data();
                p.setDataInizio(rs.getDate(1));
                p.setIdEvento(rs.getInt(2));
                p.setDataFine( rs.getDate(3));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Data> doRetrieveDatesByKey(Date dataInizio, int id) throws NumberFormatException
    {
        List<Data> list = new ArrayList<Data>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM data WHERE data_inizio=? AND id_evento=?");
            ps.setString(1, dataInizio.toString());
            ps.setString(2, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data p = new Data();
                p.setDataInizio(rs.getDate(1));
                p.setIdEvento(rs.getInt(2));
                p.setDataFine( rs.getDate(3));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Data date)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO data (data_inizio, id_evento, data_fine) VALUES(?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, date.getDataInizio());
            ps.setInt(2, date.getIdEvento());
            ps.setDate(3, date.getDataFine());
            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Date dataInizio, int id)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("Delete FROM data WHERE data_inizio =? and id_evento=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, dataInizio);
            ps.setInt(2, id);
            if (ps.executeUpdate() != 1)
            {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Data temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE data SET data_fine=? WHERE data_inizio=? AND id_evento=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, temp.getDataFine());
            ps.setDate(2, temp.getDataInizio());
            ps.setInt(3, temp.getIdEvento());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
