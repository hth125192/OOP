import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        String s = null;
        s.length();
    }

    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        String[] arr = new String[12];
        arr[19] = "";
    }

    public void arithmeticEx() {
        int a = 7 / 0;
    }

    public void fileNotFoundEx() throws FileNotFoundException {
        FileReader file = new FileReader("test.txt");
    }

    public void ioEx() throws IOException {
        FileReader file = new FileReader("test.txt");
    }

    /** nullPointerExTest. */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
            return "Không có lỗi";
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
    }

    /** arrayIndexOutOfBoundsExTest. */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
            return "Không có lỗi";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
    }

    /** arithmeticExTest. */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
            return "Không có lỗi";
        } catch (Exception e) {
            return "Lỗi Arithmetic";
        }
    }

    /** fileNotFoundExTest. */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "Không có lỗi";
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
    }

    /** ioExTest. */
    public String ioExTest() {
        try {
            ioEx();
            return "Không có lỗi";
        } catch (Exception e) {
            return "Lỗi IO";
        }
    }
}
