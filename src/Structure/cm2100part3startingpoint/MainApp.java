package Structure.cm2100part3startingpoint;


import Design.StartScreen;
import java.io.File;

public class MainApp {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
        /*if(User.registerUser("Viktoriya Yakimova")) {
            System.out.println("Successful");
            
        }
        else {
            System.out.println("Fail");
        }*/
    }
        
    /*public static void main(String[] args) {
        
        User me = new User("Silviya", 1600502);
        PlayList myMedia = new PlayList(me);
        File source = new File("/Users/ashayapi/Desktop/MediaPlayList/src/Structure/cm2100part3startingpoint/mediadata.txt");
        myMedia.readFromFile(source);
        //myMedia.loadItems("/Users/ashayapi/Desktop/CM2100Part2_1600502/src/cm2100part2/mediadata.txt");
        System.out.println(myMedia.toString());
        
        
    }*/

}
