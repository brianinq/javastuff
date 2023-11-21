package exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsPrc {
    public static void show(){
        try (var file = new FileReader("C:\\Users\\BKipkoech2\\ideaProjects\\Advanced\\src\\Main.java")){
            var value = file.read();
            System.out.println(value);
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException e) {
            System.out.println("File not found");
            System.out.println("Could not parse file");
            System.out.println(e.getMessage());
        }
    }
}
