import java.io.*;

public class Utils {
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeContentToFile1(String content, String path) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(content);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeContentToFile2(String content, String path) {
        try {
            FileWriter out = new FileWriter(path, true);
            out.write(content);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null)
            for (File file : files)
                if (file.getName().equals(fileName)) return file;
        return null;
    }

    public static void main(String[] args) {
        File file = findFileByName("C:\\Users\\nguye\\IdeaProjects\\OOP\\Week12\\Utils", "input.txt");
        if (file != null) {
            System.out.println(file.getAbsolutePath());
            String content = readContentFromFile(file.getAbsolutePath());
            writeContentToFile1(content, "C:\\Users\\nguye\\IdeaProjects\\OOP\\Week12\\Utils\\output.txt");
            writeContentToFile1("Goodbye World?\n", "output.txt");
            writeContentToFile2("Goodbye Again!?\n", "output.txt");
        }

    }
}