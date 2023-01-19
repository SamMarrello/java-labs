import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Scanner filescanner = new Scanner(new File("src/res/grades.csv"));

        String headerLine = filescanner.nextLine();

        headerLine = headerLine.replaceAll("\"", "");
        String[] headers = headerLine.split(",");

        FileWriter fileWriter = new FileWriter("src/res/grades.html");

        try {
            fileWriter = new FileWriter("src/res/grades.html");
            filescanner = new Scanner(new File("src/res/grades.csv"));
        }
        catch(Exception ex) {
            throw new IOException();
        }

        StringBuilder builder = new StringBuilder();

        builder.append("<table>").append("\n");builder.append("<tr>");
        for (int i = 0; i < headers.length; i++) {
            builder.append("<th>").append(headers[i]).append("</th>").append("\n");
        }
        builder.append("</tr>").append("\n");
        builder.append("</table>");

        fileWriter.append(builder.toString());
        fileWriter.close();
    }
}
