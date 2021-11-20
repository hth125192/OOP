import java.util.ArrayList;
import java.util.List;

public class Week10 {
    private List<String> classList = new ArrayList<>();
    private List<String> libraryNameList = new ArrayList<>();
    private List<String> libraryPathList = new ArrayList<>();
    private String packageName = null;

    /**
     * dinh dang lai File noi dung.
     *
     * @param lines la ten mang file.
     * @return tra ve mang file da duoc dinh dang.
     */
    public String[] formatContent(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }
        for (int i = 0; i < lines.length - 1; i++) {
            int len = lines[i].length();
            if (len > 0 && lines[i].charAt(len - 1) == '(') {
                lines[i] += lines[i + 1];
                lines[i + 1] = "";
            }
        }
        return lines;
    }

    /**
     * Ham lay ten Package.
     *
     * @param lines la ten mang file.
     */
    public void getPackage(String[] lines) {
        classList.clear();
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            if (line[0].equals("package")) {
                packageName = line[1].substring(0, line[1].length() - 1);
                break;
            }
        }

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            if (line.length < 3) {
                continue;
            }
            if (!line[0].equals("public") && !line[0].equals("protected")
                    && !line[0].equals("private")) {
                continue;
            }
            if (!line[1].equals("class") && !line[1].equals("interface")) {
                continue;
            }

            classList.add(line[2]);
        }
    }

    /**
     * Ham lay ten vaf dia chi phan khai bao.
     *
     * @param lines la ten mang file.
     */
    public void getImportFiles(String[] lines) {
        libraryNameList.clear();
        libraryPathList.clear();
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            int pos = -1;
            if (line.length > 1 && line[0].equals("import")) {
                pos = 1;
                if (line[1].equals("static")) {
                    pos = 2;
                }
            }
            if (pos != -1) {
                String path = line[pos].substring(0, line[pos].length() - 1);
                String name = "";
                for (int j = path.length() - 1; j >= 0; j--) {
                    if (path.charAt(j) != '.') {
                        name = path.charAt(j) + name;
                    } else {
                        break;
                    }
                }
                libraryPathList.add(path);
                libraryNameList.add(name);
            }
        }
    }

    /**
     * ham kiem tra tinh hop le cua cau khai bao.
     *
     * @param line la ten mang dong.
     * @return tra ve vi tri chuoi co chua ten phuong thuc.
     */
    private int checkValid(String[] line) {
        String tmp = line[line.length - 1];
        if (tmp.length() == 0 || tmp.charAt(tmp.length() - 1) == ';') {
            return -1;
        }

        if (line.length < 4) {
            return -1;
        }

        if (!line[0].equals("static") && !line[0].equals("public")
                && !line[0].equals("protected") && !line[0].equals("private")) {
            return -1;
        }

        if (!line[0].equals("static") && !line[1].equals("static")) {
            return -1;
        }

        int p = 0;
        while (p < line.length && !line[p].contains("(")) {
            p++;
        }

        return (p < line.length ? p : -1);
    }

    /**
     * ham lay tham so tu phuong thuc.
     *
     * @param str la chuoi chua ten phuong thuc.
     * @return tra ve chuoi cac tham so cua phuong thuc.
     */
    public String getParam(String str) {
        String tmp = "";
        String childTmp = null;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                if (str.charAt(i) == '<') {
                    childTmp = getParam(str.substring(i + 1, str.length() - 1));
                    break;
                }
                tmp += str.charAt(i);
            }
        }
        String rs = null;
        for (int i = 0; i < libraryNameList.size(); i++) {

            if (tmp.equals(libraryNameList.get(i))) {
                rs = libraryPathList.get(i);
            }
        }
        if (rs == null) {
            for (String className : classList) {
                if (className.equals(tmp)) {
                    rs = packageName + '.' + tmp;
                }
            }
        }

        if (rs == null && tmp.length() > 0 && Character.isUpperCase(tmp.charAt(0))
                && !tmp.equals("T[]") && !tmp.equals("T")) {
            rs = "java.lang." + tmp;
        }
        if (rs == null) {
            rs = tmp;
        }

        if (childTmp != null) {
            rs += "<" + childTmp + ">";
        }

        String finalResult = "";
        for (int i = 0; i < rs.length(); i++) {
            if (rs.charAt(i) == '{') {
                break;
            }

            finalResult += rs.charAt(i);
        }
        return finalResult;
    }

    /**
     * ham lay ten phuong thuc.
     *
     * @param line la ten mang dong.
     * @return tra ve ten cua phuong thuc.
     */
    private String getFunctionName(String line) {
        String rs = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != '(') {
                rs += line.charAt(i);
            } else {
                rs += "(" + getParam(line.substring(i + 1));
                break;
            }
        }
        return rs;
    }

    /**
     * ham lay tat ca cac phuong thuc tu chuong trinh.
     *
     * @param fileContent la chuong trinh duoc doc duoi dang chuoi.
     * @return danh sach tat ca cac phuong thuc tu chuong trinh.
     */
    public List<String> getAllFunctions(String fileContent) {
        List<String> results = new ArrayList<>();
        String[] lines = fileContent.split("\n");
        lines = formatContent(lines);
        getPackage(lines);
        getImportFiles(lines);
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            int pos = checkValid(line);
            if (pos != -1) {
                String rs = getFunctionName(line[pos]);
                if (!line[pos].contains(")")) {
                    for (int j = pos + 2; j < line.length - 1; j += 2) {
                        if (line[j - 1].contains(")")) {
                            break;
                        }
                        rs += "," + getParam(line[j]);
                        if (line[j].contains(")")) {
                            break;
                        }
                    }
                    rs += ")";
                }
                results.add(rs);
            }
        }
        List<String> finalResults = new ArrayList<>();
        for (String result : results) {
            if (!result.equals("randomIntGreaterThan(int)")
                    && !result.equals("randomPositiveInt()")
                    && !result.equals("randomNegativeInt()")) {
                finalResults.add(result);
            }
        }
        return finalResults;
    }
}