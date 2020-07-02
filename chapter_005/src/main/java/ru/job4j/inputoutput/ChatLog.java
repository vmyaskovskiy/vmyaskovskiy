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
    public void setLog(String log) {
        this.log.add(log);
    }
    public ArrayList<String> getLog() {
        return this.log;
    }
    public void fileWr() {
        ArrayList<String> log = getLog();
        String path = "C:/projects/vmyaskovskiy/chapter_005/logChat.txt";
        try(FileWriter writer = new FileWriter(path)) {
            for(String logCh: log) {
                writer.append(logCh);
                writer.append('\n');
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
    public void print () {
        try (FileInputStream inputStream = new FileInputStream("C:/projects/vmyaskovskiy/chapter_005/1.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            String logChat = lines[(int) (Math.random() * lines.length)];
            setLog(logChat);
            System.out.println(logChat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatLog chatLog = new ChatLog();
        String end = "завершить";
        String stop = "стоп";
        String begin = "продолжить";

        Scanner in = new Scanner(System.in);
        System.out.println("введи свой вопрос: ");
        chatLog.setLog("введи свой вопрос: ");
        while(true) {
            String qes = in.nextLine();
            chatLog.setLog(qes);
            if (qes.equals(end)) {
                System.out.println("программа остановлена");
                chatLog.setLog("программа остановлена");
                chatLog.fileWr();
                break;
            } else if(qes.equals(stop)) {
                chatLog.setStop(1);
                System.out.println("программа перестает отвечать на вопросы");
                chatLog.setLog("программа перестает отвечать на вопросы");
            } else if(qes.equals(begin)) {
                chatLog.setStop(0);
                chatLog.print();
            } else {
                if(chatLog.getFlagStop() == 0) {
                    chatLog.print();
                }
            }
        }
    }
}
