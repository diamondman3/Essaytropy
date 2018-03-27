import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

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
        double totalChars=0;
        ArrayList<Integer> spaces=new ArrayList<Integer>();
        while(scanner.hasNext()&&scanner!=null){
            currentLine=scanner.nextLine();
            for(int i=0; i<currentLine.length(); i++) {
                totalChars++;
                char c = currentLine.charAt(i);
                if((int)c==(int)' '){
                    spaces.add(new Integer((int)totalChars));
                }
            }
        }
        try{scanner = new Scanner(essay);}catch (Exception e){e.printStackTrace();}
        while(scanner.hasNext()&&scanner!=null){
            currentLine=scanner.next();
            for(int i=0; i<currentLine.length(); i++) {
                charNumber++;
                current=currentLine.charAt(i)+"";
                if (Math.random()<=charNumber/(totalChars*5)) {
                    current = "" + (char) (Math.random() * 256);
                }
                if (entropyWriter != null) {
                    if(spaces.contains(new Integer((int)(charNumber)))){
                        entropyWriter.write(" ");
                        charNumber++;
                    }
                    entropyWriter.write(current);
                }
            }
        }

        entropyWriter.close();
        System.out.println("Done");
    }
}
