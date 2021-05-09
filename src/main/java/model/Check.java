package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Check {

    static boolean isFloat(Object c){
        Float f = null;
        if(c.getClass()==f.getClass())
            return true;
        return false;
    }

    static boolean isString(Object c){
        String s = null;
        if(c.getClass()==s.getClass())
            return true;
        return false;
    }

    static boolean isInt(Object c){
        Integer i = null;
        if(c.getClass()==i.getClass())
            return true;
        return false;
    }

    static boolean isDate(Object c){
        Date d = null;
        if(c.getClass()==d.getClass())
            return true;
        return false;
    }

    static boolean isTime(Object c){
        Time t = null;
        if(c.getClass()==t.getClass())
            return true;
        return false;
    }

    static int mailIsValid(String mail)
    {
        if(mail=="" || mail==null) return -1;
        if(!(mail.contains("@"))) return -2;
        ArrayList<Utente> array = new ArrayList<>();
        UtenteDAO users = new UtenteDAO();
        array= (ArrayList<Utente>) users.doRetrieveAllUsers();
        for(Utente x: array)
        {
            if(x.getMail().equals(mail))
                return -3;
        }
        return 0;
    }

    static int usernameIsValid(String username)
    {
        if(username=="" || username==null) return -1;
        if(username.length()<8) return -2;
        if(username.length()>20) return -3;
        ArrayList<Utente> array = new ArrayList<>();
        UtenteDAO users = new UtenteDAO();
        array= (ArrayList<Utente>) users.doRetrieveAllUsers();
        for(Utente x: array)
        {
            if(x.getNomeUtente().equals(username))
                return -4;
        }
        return 0;
    }

    static int passwordIsValid(String password)
    {
        if(password=="" || password==null) return -1;
        if(password.length()<8) return -2;
        if(password.length()>16) return -3;
        if(password.equals(password.toLowerCase())) return -4;
        if(password.equals(password.toUpperCase())) return -5;
        if(!password.matches("(.*[0-9].*)")) return -6;
        if(!(password.contains("@") || password.contains("%") || password.contains(".") ||
                password.contains("&") || password.contains("$") || password.contains("£") ||
                password.contains("\"") || password.contains("\\") || password.contains("/") ||
                password.contains("€") || password.contains("(") || password.contains(")") ||
                password.contains("!") || password.contains("?") || password.contains("'") ||
                password.contains("+") || password.contains("-") || password.contains("*") ||
                password.contains("=") || password.contains("#") || password.contains("-") ||
                password.contains("_") || password.contains("[") || password.contains("]") ||
                password.contains("{") || password.contains("}") || password.contains("§") ||
                password.contains("^") || password.contains("ç") || password.contains("°") ||
                password.contains("<") || password.contains(">") || password.contains(";") ||
                password.contains(":") || password.contains(","))) return -7;
        return 0;
    }
}
