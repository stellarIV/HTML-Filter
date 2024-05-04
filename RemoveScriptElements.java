import java.io.*;

public class RemoveScriptElements {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.html"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("filtered.html"));
            
            String line;
            boolean insideScript = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<script")) {
                    insideScript = true;
                } else if (line.contains("</script>")) {
                    insideScript = false;
                } else if (!insideScript) {
                    writer.write(line.replaceAll("<script.*?>|</script>", ""));
                    writer.newLine();
                }
            }
            
            reader.close();
            writer.close();
            
            System.out.println("Script content and tags removed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
