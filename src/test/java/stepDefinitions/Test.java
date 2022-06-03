package stepDefinitions;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            Thread.sleep(5 * 60 * 1000);
            int x = random.nextInt() % 640;
            int y = random.nextInt() % 480;
            hal.mouseMove(x,y);
            System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        }
    }
}
