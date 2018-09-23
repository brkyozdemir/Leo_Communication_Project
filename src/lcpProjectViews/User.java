/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcpProjectViews;

/**
 *
 * @author OmerCeylan
 */
public class User {
    public static User LoggedUSER = new User();
    private int id;
    private String userName;
    private String password;
    private String email;
    private String club;
    private int isPresident;

    public User(){
        userName = "";
        password = "";
        email = "";
        club = "";
        isPresident = 0;
    }
    

    public User(String userName, String password, String email, String club, int isPresident){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.club = club;
        this.isPresident = isPresident;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String eMail){
        this.email = eMail;
    }
    
    public int getPresident(){
        return isPresident;
    }
    
    public boolean isPresident(){
        if(isPresident == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public void setPresident(int presidency){
        this.isPresident = presidency;
    }
    
    public String getClub(){
        return club;
    }
    
    public void setClub(String club){
        this.club = club;
    }
}
