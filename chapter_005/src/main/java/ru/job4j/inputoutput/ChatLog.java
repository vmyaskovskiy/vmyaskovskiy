package ru.job4j.inputoutput;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class ChatLog решение задачи  6. Кодировка.[862#143745] программа 'Консольный чат'
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ChatLog {
    private int flagStop = 0;
    private ArrayList<String> log = new ArrayList<>();
    private ArrayList<String> chat = new ArrayList<>();
    public void setLog(String log) {
        this.log.add(log);
    }
    public ArrayList<String> getLog() {
        return this.log;
    }
    public void fileWr(String path) {
        ArrayList<String> log = getLog();
        try (FileWriter writer = new FileWriter(path)) {
            for (String logCh: log) {
                writer.append(logCh);
                writer.append(System.lineSeparator());
            }
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void setStop(int stop) {
        this.flagStop = stop;
    }
    public int getFlagStop() {
        return this.flagStop;
    }
    public void print(String path) {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) {
                text.append((char) read);
            }
          String[] lines = text.toString().split(System.lineSeparator());
            for (String str: lines) {
                this.chat.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chat(String fileChat, String fileChatLog) {
        print(fileChat);
        String end = "завершить";
        String stop = "стоп";
        String begin = "продолжить";
        String qes = "null";
        Scanner in = new Scanner(System.in);
        System.out.println("введи свой вопрос: ");
        setLog("введи свой вопрос: ");
        while (!qes.equals(end)) {
            qes = in.nextLine();
            setLog(qes);
            if (qes.equals(end)) {
                System.out.println("программа остановлена");
                setLog("программа остановлена");
                fileWr(fileChatLog);
            } else if (qes.equals(stop)) {
                setStop(1);
                System.out.println("программа перестает отвечать на вопросы");
                setLog("программа перестает отвечать на вопросы");
            } else if (qes.equals(begin) || (getFlagStop() == 0)) {
                setStop(0);
                String logChat = this.chat.get((int) (Math.random() * chat.size()));
                setLog(logChat);
                System.out.println(logChat);
            }
        }
    }

    public static void main(String[] args) {
        // занес в параметры конфигурации args следующие данные:
        // -d=C:/projects/vmyaskovskiy/chapter_005/
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Args args1 = Args.of(args);
        ChatLog chatLog = new ChatLog();
        chatLog.chat(args1.get("-d") + "1.txt", args1.get("-d") + "logChat.txt");
    }
}