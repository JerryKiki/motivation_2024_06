package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.motivation.entity.Motivation;
import org.koreait.system.controller.SystemController;

import java.util.*;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation execution ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("\ncommand) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.isEmpty()) {
                motivationController.notice(1);
                continue;
            }

            if (cmd.equals("add")) motivationController.add();
            else if (cmd.equals("list")) motivationController.list();
            else if (cmd.equals("help")) motivationController.help();
            else motivationController.notice(2);
        }
    }
}

