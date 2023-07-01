import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    @Test
    public void test1(){
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        Main main = new Main();
        boolean result = main.Program(in);
        assertFalse(result);
    }

    @Test
    public void test2(){
        Main main = new Main();
        String[] list = {"Задача 1", "Задача 2", "Задача 3"};
        String answer = "Задача 1\nЗадача 2\nЗадача 3\n";
        for (String l: list){
            ByteArrayInputStream in = new ByteArrayInputStream(l.getBytes());
            main.addWork(in);
        }
        String result = "";

        for (String t: main.tasks){
            result = result + t +"\n";
        }

        assertThat(result, equalToIgnoringCase(answer));
    }

    @Test
    public void test3(){
        Main main = new Main();
        String[] list = {"Задача 1", "Задача 2", "Задача 3"};
        String answer = "Список задач:1. Задача 12. Задача 23. Задача 3";
        for (String l: list){
            ByteArrayInputStream in = new ByteArrayInputStream(l.getBytes());
            main.addWork(in);
        }

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        main.printAllWorks();
        String result = output.toString().replaceAll("\n", "").replaceAll("\r", "");

        for (String l: list){
            assertThat(result, containsString(l));
        }
    }

    @Test
    public void test4(){
        Main main = new Main();
        String[] list = {"Задача 1", "Задача 2", "Задача 3"};
        String answer = "Задача 3";
        for (String l: list){
            ByteArrayInputStream in = new ByteArrayInputStream(l.getBytes());
            main.addWork(in);
        }
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        main.deleteWork(in);

        assertThat(output.toString(), not(containsString(answer)));
    }

    @Test
    public void test5(){
        ByteArrayInputStream in = new ByteArrayInputStream("dfdfdf".getBytes());
        Main main = new Main();
        boolean result = main.Program(in);
        assertTrue(result);
    }
}

