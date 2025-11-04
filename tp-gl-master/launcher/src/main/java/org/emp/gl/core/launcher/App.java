package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();
    }

    private static void testDuTimeService() {

        TimerService timerService = new DummyTimeServiceImpl();

        Horloge horloge1 = new Horloge("Horloge 1", timerService);
        Horloge horloge2 = new Horloge("Horloge 2", timerService);
        Horloge horloge3 = new Horloge("Horloge 3", timerService);

        System.out.println("\n=== Trois horloges actives ===\n");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
