package Structure.cm2100part3startingpoint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

/**
 * CM2100 Coursework Part 3 Starting point
 * Class to store details of a User that will be associated with a MediaList
 * @author David
 */
public class User {
    
    private final String username;
    private int wallet;

    public User(String name, int pence) {
        this.username = name;
        this.wallet = pence;
    }

    public String getUsername() {
        return username;
    }
    
    public void topUp(int pence){
        wallet += pence;
    }
    
    public int getWallet(){
        return wallet;
    }
    
    public boolean purchase(Media m){
        if(wallet >= m.costInPence()){
            wallet -= m.costInPence();
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return username + " £" + wallet/100 + "." + wallet%100;
    }   
    
    //-------------------------------------Additional or Modified Methods-------------------------------------
    
    //Method that I have added in order to validate users trying to register
    //It reads the name from the registration text field and looks for it in the database
    //Returns true if the name already exists in the database
    public static boolean checkDatabase(String username) {
        boolean flag = false;
        try {
            File database = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/userDatabase.txt");
            Scanner s = new Scanner(database);
            // For each Item
            while (s.hasNextLine()){
                
                // Read the username and their wallet
                String line = s.nextLine();
                //System.out.println(line);
                String[] entries = line.split(",");
                String name = entries[0];
                String money = entries[1];
                if(username.equals(name)) {
                    flag = true;
                    break;
                }
            }
            s.close();
        } catch (FileNotFoundException ex) {}
        return flag;
    }
    
    
    //This method is used to obtain the wallet balance 
    //of the user who is logging in from the database
    public static User logIn(String username) {
        String name = "";
        int money = 0;
        try {
            File database = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/userDatabase.txt");
            Scanner s = new Scanner(database);
            while (s.hasNextLine()){
                String line = s.nextLine();
                String[] entries = line.split(",");
                name = entries[0];
                money = Integer.parseInt(entries[1]);
                if(username.equals(name)) {
                    break;
                }
            }
            s.close();
        } catch (FileNotFoundException ex) {}
        return new User(name,money);
    }
    
    //This method is used to register a new user  
    //The method creates a new entry in the database 
    //with a given username and initial balance of £10
    //Returns true if the action was successful
    public static boolean registerUser(String username) {
        boolean flag = true;
        try {
            File database = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/userDatabase.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(database, true));
            String entry = username + ",1000";
            bw.write(entry);
            bw.newLine();
            bw.flush();
            bw.close();
        } 
        catch (Exception ex) {
            flag = false;
        }
        return flag;
    }
    
    
    //A method to update user information in the database
    //Used to update the wallet or change the username
    //Returns true if the update was successful
    public static boolean updateDatabase(User user, String oldName) {
        boolean flag = true;
        try {
            File database = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/userDatabase.txt");
            File temp = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/temp.txt");
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            Scanner s = new Scanner(database);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] entries = line.split(",");
                String name = entries[0];
                int money = Integer.parseInt(entries[1]);
                if(!(oldName.equals(name))) {
                    String entry = name + "," + money;
                    bw.write(entry);
                    bw.newLine();
                }
                else {
                    String entry = user.getUsername() + "," + user.getWallet();
                    bw.write(entry);
                    bw.newLine();
                }
            }
            s.close();
            bw.flush();
            bw.close();
            database.delete();
            temp.renameTo(new File("/Users/ashayapi/Desktop/MediaPlayList/src/Database/userDatabase.txt"));
            
        }
        catch (Exception ex) {
            flag = false;
        }
        return flag;
    }
}
