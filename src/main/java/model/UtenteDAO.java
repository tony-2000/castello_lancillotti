package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO
{
    public List<Utente> doRetrieveAllUsers()
    {
        List<Utente> list = new ArrayList<Utente>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utente p = new Utente();
                p.setIdUtente(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setAmministratore(rs.getBoolean(4));
                p.setTelefono(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setNomeUtente(rs.getString(7));
                p.setPassword(rs.getString(8));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Utente> doRetrieveUsersByKey(int id) throws NumberFormatException
    {
        List<Utente> list = new ArrayList<Utente>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE id_utente=?");
            ps.setString(1, Integer.toString(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Utente p = new Utente();
                p.setIdUtente(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setAmministratore(rs.getBoolean(4));
                p.setTelefono(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setNomeUtente(rs.getString(7));
                p.setPassword(rs.getString(8));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Utente doRetrieveByUsernamePassword(String nomeUtente, String password)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE nome_utente=? AND password=SHA1(?)");
            ps.setString(1, nomeUtente);
            ps.setString(2, password);
            Utente p = new Utente();
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                p.setIdUtente(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setAmministratore(rs.getBoolean(4));
                p.setTelefono(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setNomeUtente(rs.getString(7));
                p.setPassword(rs.getString(8));
            }
            else p=null;
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Utente customer)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO utente (nome,cognome,amministratore,telefono,mail,nome_utente,password) VALUES(?,?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getNome());
            ps.setString(2, customer.getCognome());
            ps.setBoolean(3, false);
            ps.setString(4, customer.getTelefono());
            ps.setString(5, customer.getMail());
            ps.setString(6, customer.getNomeUtente());
            ps.setString(7, customer.getPassword());
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
                    ("Delete FROM utente WHERE id_utente=?",
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

    public void doUpdateUserInfo(Utente temp )
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE utente SET nome=?,cognome=?, " +
                            "telefono=?, mail=? WHERE id_utente=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, temp.getNome());
            ps.setString(2, temp.getCognome());
            ps.setString(3, temp.getTelefono());
            ps.setString(4, temp.getMail());
            ps.setInt(5, temp.getIdUtente());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateUsername(Utente temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE utente SET nome_utente=? WHERE id_utente=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, temp.getNomeUtente());
            ps.setInt(2, temp.getIdUtente());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doUpdatePassword(Utente temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE utente SET password=? WHERE id_utente=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, temp.getPassword());
            ps.setInt(2, temp.getIdUtente());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doAddAdmin(Utente temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE utente SET amministratore=true WHERE id_utente=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, temp.getIdUtente());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doRemoveAdmin(Utente temp)
    {
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("UPDATE utente SET amministratore=false WHERE id_utente=? ",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, temp.getIdUtente());
            ps.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
