package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

import java.util.Random;

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

        /*
        Horloge horloge1 = new Horloge("Horloge 1", timerService);
        Horloge horloge2 = new Horloge("Horloge 2", timerService);
        Horloge horloge3 = new Horloge("Horloge 3", timerService);

        System.out.println("\n=== Trois horloges actives ===\n");
        */


        Random random = new Random();

        // Créer 10 comptes à rebours avec valeurs entre 10 et 20
        for (int i = 1; i <= 10; i++) {
            int valeurAleatoire = 10 + random.nextInt(11); // 10 à 20
            new CompteARebours("Compte-" + i, valeurAleatoire, timerService);
        }

        System.out.println("\n=== 10 comptes à rebours actifs ===\n");

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
