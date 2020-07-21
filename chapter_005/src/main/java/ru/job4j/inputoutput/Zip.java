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
        List<File> res = search.files(str, condition);
        return res;
    }

    public void pack(List<File> files, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: files) {
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
        // занес в параметры конфигурации args следующие данные:
        // -d=C:/projects/vmyaskovskiy/chapter_005/data
        // -e=log
        // -o=project.zip
        Zip zip = new Zip();
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Args jvm = Args.of(args);
        File fileDirectory = new File(jvm.get("-d"));
        if (!fileDirectory.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", fileDirectory.getAbsoluteFile()));
        }
        List<File> files = zip.seekBy(jvm.get("-d"), jvm.get("-e"));
        zip.pack(files, new File("C:/projects/vmyaskovskiy/chapter_005/" + jvm.get("-o")));
    }
}

