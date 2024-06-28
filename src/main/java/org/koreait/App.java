package org.koreait;

import java.util.*;

public class App {

    private Scanner sc;
    private int lastId;
    private List<Motivation> motivations;

    public App(Scanner sc) {
        this.sc = sc;
        this.lastId = 0;
        this.motivations = new ArrayList<>();
    }

    public void run() {
        System.out.println("== motivation execution ==");

        while (true) {
            System.out.print("\ncommand) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== exit motivation ==");
                break;
            } else if (cmd.isEmpty()) {
                notice(1);
                continue;
            }

            if (cmd.equals("add")) add();
            else if (cmd.equals("list")) list();
            else if (cmd.equals("help")) help();
            else {
                notice(2);
            }
        }
    }

    void add() {
        this.lastId++;
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("source : ");
        String source = sc.nextLine();
        Motivation newMo = new Motivation(this.lastId, body, source);
        this.motivations.add(newMo);
        System.out.printf("%d번 motivation이 등록되었습니다.\n", this.lastId);
    }

    void list() {
        if(this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        }
        else {
            System.out.printf("등록된 motivation의 개수는 %d개 입니다.\n", this.lastId);
            System.out.println("===== motivation list =====");
            System.out.println("   id   //   motivation   //   source   ");

            for (int i = this.lastId - 1; i >= 0; i--) {
                int nowId = motivations.get(i).getMyId();
                String nowBody = motivations.get(i).getBody();
                String nowSource = motivations.get(i).getSource();
                System.out.printf("   %d    //     %s     //     %s     \n", nowId, nowBody, nowSource);
            }
        }
    }

    void help() {
        System.out.println("== 사용 가능한 명령어 목록 ==");
        System.out.println("help : 사용 가능한 명령어 목록을 불러옵니다.");
        System.out.println("add : 새로운 motivation을 등록합니다.");
        System.out.println("list : 등록된 motivation의 목록을 불러옵니다.");
        System.out.println("exit : motivation app을 종료합니다.");
    }

    void notice(int i) {

        switch (i) {
            case 1:
                System.out.println("명령어를 입력해주세요.");
                System.out.println("사용 가능한 명령어 목록이 필요하시다면, help를 입력해주세요.");
                break;
            case 2:
                System.out.println("올바른 명령어를 입력해주세요.");
                System.out.println("사용 가능한 명령어 목록이 필요하시다면, help를 입력해주세요.");
                break;
        }

    }
}
