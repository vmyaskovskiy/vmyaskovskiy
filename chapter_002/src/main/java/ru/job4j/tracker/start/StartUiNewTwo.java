package ru.job4j.tracker.start;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Consumer;

public class StartUiNewTwo {
    private Input input;
    private SqlTracker trackerTwo;
    private boolean exit = false;
    private final  Consumer<String> output;

    static Connection connection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return  DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
public StartUiNewTwo(Input input, SqlTracker trackerTwo, Consumer<String> output) {
        this.input = input;
        this.trackerTwo = trackerTwo;
        this.output = output;

        }

        /**
 * Основой цикл программы.
 */
public void init() throws SQLException {

        MenuTrackerTwo menu = new MenuTrackerTwo(this.input, this.trackerTwo, this, this.output);
        menu.fillAction();
        int[] range = menu.range();
        while (!exit) {
        menu.show();
        int key = input.ask("Select", range);
        menu.select(key);
        }
        }



public static void main(String[] args) throws SQLException {

    new StartUiNewTwo(new ValidateInput(new ConsoleInput()), new SqlTracker(connection()), System.out::println).init();
        }

public void setExit(boolean exit) {
        this.exit = exit;
        }
        }

