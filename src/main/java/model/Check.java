package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Check {

    public static boolean isFloat(Object c){
        Float f = null;
        if(c.getClass()==f.getClass())
            return true;
        return false;
    }

   public static boolean isString(Object c){
        String s = null;
        if(c.getClass()==s.getClass())
            return true;
        return false;
    }

   public  static boolean isInt(Object c){
        Integer i = null;
        if(c.getClass()==i.getClass())
            return true;
        return false;
    }

    public static boolean isDate(Object c){
        Date d = null;
        if(c.getClass()==d.getClass())
            return true;
        return false;
    }

    public static boolean isTime(Object c){
        Time t = null;
        if(c.getClass()==t.getClass())
            return true;
        return false;
    }

   public static int mailIsValid(String mail)
    {
        if(mail=="" || mail==null) return -1;
        if(!(mail.contains("@"))) return -2;
        if(!(mail.contains("."))) return -3;
        if(mail.length()<6) return -4;
        if(mail.length()>40) return -5;
        ArrayList<Utente> array = new ArrayList<>();
        UtenteDAO users = new UtenteDAO();
        array= (ArrayList<Utente>) users.doRetrieveAllUsers();
        for(Utente x: array)
        {
            if(x.getMail().equals(mail))
                return -6;
        }
        return 0;
    }

   public static int usernameIsValid(String username)
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

    public static int passwordIsValid(String password, String passwordCheck)
    {
        if(!password.equals(passwordCheck)) return -1;
        if(password=="" || password==null) return -2;
        if(password.length()<8) return -3;
        if(password.length()>16) return -4;
        if(password.equals(password.toLowerCase())) return -5;
        if(password.equals(password.toUpperCase())) return -6;
        if(!password.matches("(.*[0-9].*)")) return -7;
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
                password.contains(":") || password.contains(","))) return -8;
        return 0;
    }

    public static int nameIsValid(String name)
    {
        if(name=="" || name==null) return -1;
        if(name.length()<2) return -2;
        if(name.length()>30) return -3;
        return 0;
    }

    public static int surnameIsValid(String surname)
    {
        if(surname=="" || surname==null) return -1;
        if(surname.length()<2) return -2;
        if(surname.length()>30) return -3;
        return 0;
    }

    public static int telephoneisValid(String telephone)
    {
        if(telephone=="" || telephone==null) return -1;
        if(telephone.length()<9) return -2;
        if(telephone.length()>12) return -3;
        int i=0;
        char temp;
        while(i<telephone.length())
        {
            temp=telephone.charAt(i);
            if(!Character.isDigit(temp))
                return -4;
            i++;
        }
        return 0;
    }
}