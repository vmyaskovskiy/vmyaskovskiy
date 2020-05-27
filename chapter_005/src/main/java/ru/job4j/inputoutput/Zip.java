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
        Predicate<String> condition = (s) -> s.contains(ext);
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
}

