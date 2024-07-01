package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.motivation.entity.Motivation;
import org.koreait.system.controller.SystemController;

import java.util.*;

public class App {

    public void run() {
        System.out.println("== motivation execution ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("\ncommand) ");
            String cmd = Container.getScanner().nextLine().trim();

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
            else if (cmd.equals("delete")) motivationController.deleteMotivation();
            else if (cmd.startsWith("delete?id=")) motivationController.deleteMotivation(cmd);
            else if (cmd.equals("edit")) motivationController.editMotivation();
            else if (cmd.startsWith("edit?id=")) motivationController.editMotivation(cmd);
            else motivationController.notice(2);
        }
    }
}

