package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO
{
    public List<Categoria> doRetrieveAllCategories()
    {
        List<Categoria> list = new ArrayList<Categoria>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria p = new Categoria();
                p.setIdCategoria(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setLinkImmagine(rs.getString(3));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Categoria doRetrieveCategoriesByKey(int id) throws NumberFormatException
    {
        Categoria cat = new Categoria();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM categoria WHERE id_categoria=?");
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cat.setIdCategoria(rs.getInt(1));
                cat.setNome(rs.getString(2));
                cat.setLinkImmagine(rs.getString(3));
            }
            return cat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Categoria cat)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO categoria (nome,link_immagine) VALUES(?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat.getNome());
            ps.setString(2,cat.getLinkImmagine());
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
                    ("Delete FROM Categoria WHERE id_categoria=?",
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

    public void doUpdate(Categoria temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE categoria SET nome=?, link_immagine=? WHERE id_categoria=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, temp.getNome());
            ps.setString(2, temp.getLinkImmagine());
            ps.setInt(3, temp.getIdCategoria());

            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
