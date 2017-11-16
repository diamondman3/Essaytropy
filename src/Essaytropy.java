import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.io.*;
import java.util.Scanner;

/**
 * Created by maxwelljm19 on 11/13/2017.
 */
public class Essaytropy {
    public static void main(String[] args) throws IOException{
        File essay;
        final JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");
        chooser.setVisible(true);
        chooser.setDialogTitle("Choose text to entropy");
        int itNeedsThisToWorkIDontKnowWhy = chooser.showOpenDialog(null);
        essay = chooser.getSelectedFile();
        File essaytropy=new File(essay.getPath().substring(0, essay.getPath().indexOf("."))+"tropy"+essay.getPath().substring(essay.getPath().indexOf(".")));
        Writer entropyWriter=null;
        try {
            essaytropy.createNewFile();
            entropyWriter=new PrintWriter(essaytropy.getPath(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner=null;
        try{scanner = new Scanner(essay);}catch (Exception e){e.printStackTrace();}
        String current="";
        String currentLine="";
        double charNumber=0;
        while(scanner.hasNext()&&scanner!=null){
            currentLine=scanner.next();
            for(int i=0; i<currentLine.length(); i++) {
                charNumber++;
                current=currentLine.charAt(i)+"";
                if (Math.pow(Math.E, charNumber / 250) > Math.random() * 1000) {
                    current = "" + (char) (Math.random() * 256);
                }
                if (entropyWriter != null) {
                    entropyWriter.write(current);
                }
            }
        }
        entropyWriter.close();
        System.out.println("Dףסי");
    }
}
