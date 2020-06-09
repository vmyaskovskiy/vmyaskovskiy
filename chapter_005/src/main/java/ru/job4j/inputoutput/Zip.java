package ru.job4j.inputoutput;
import java.io.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * Class Search решение задачи  4. Архивировать проект. [#143744]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Zip {

    public List<File> seekBy(String root, String ext) {
        String str = root;
        Search search = new Search();
        Predicate<String> condition = (s) -> !s.contains(ext);
        List<File> res = search.files(str,condition);
        return res;
    }

    public void pack(List<File> files, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target))))
        {
            for(File file: files) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                  try   (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.getPath()))) {
                      zip.write(out.readAllBytes());
                  }
            }
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        //0 - "C:/projects/vmyaskovskiy/chapter_005/data"
        //1 - "log"
        //2 - "C:/projects/vmyaskovskiy/chapter_005/pom3.zip"
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File fileDirectory = new File(args[0]);
        if (!fileDirectory.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", fileDirectory.getAbsoluteFile()));
        }
        File fileTarget = new File(args[2]);
        if (!fileTarget.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not exist %s", fileTarget.getAbsoluteFile()));
        }
        List<File> files = zip.seekBy(args[0], args[1]);
        zip.pack(files, new File(args[2] + "/pom3.zip"));
    }
}

