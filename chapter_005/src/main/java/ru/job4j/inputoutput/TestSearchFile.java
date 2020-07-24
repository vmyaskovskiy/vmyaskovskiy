package ru.job4j.inputoutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestSearchFile {
    private Predicate<String> condition;
    public List<File> seekBy(String root, String ext, String flag) {
        String str = root;
        Search search = new Search();
        if (flag.equals("-m")) {
            condition = (s) -> s.contains(ext);
        } else if (flag.equals("-f")) {
            condition = (s) -> s.equals(ext);
        }
        List<File> res = search.files(str, condition);
        System.out.println(res);
        return res;
    }
    public void findFile(String root, String ext, String flag, String target, String nameFileOut) throws IOException {
        List<File> res = seekBy(root, ext, flag);
        List<String> lines = new ArrayList<>();
        for (File file: res) {
            lines.add(file.getName());
        }
        System.out.println(lines);
        Path path = Paths.get(target + nameFileOut);
        Path outFile = Files.createFile(path);
            Files.write(outFile, lines);
    }

    public static void main(String[] args) throws IOException {
        // занес в параметры конфигурации args следующие данные:
        // ключи
        //-d=C:/projects- директория в которая начинать поиск.
        // -fm - искать по макс, либо -ff - полное совпадение имени. -r регулярное выражение.
        // -m="Chat.txt"
        // -f="logChat.txt"
        // -o="FilLog.txt" - результат записать в файл.
        // -t=C:/projects/vmyaskovskiy/chapter_005/data/ - директория в которую записать файл

        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Args args1 = Args.of(args);
        TestSearchFile testSearchFile = new TestSearchFile();
        testSearchFile.findFile(args1.get("-d"),
                                args1.get("-m"),
                                args1.get("-fm"),
                                args1.get("-t"),
                                args1.get("-o"));
    }
}
