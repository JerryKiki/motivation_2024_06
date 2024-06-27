package org.koreait;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private int moId;

    public App(Scanner sc){
        this.sc = sc;
        this.moId = 0;
    }

    public void run() {
        System.out.println("== motivation 실행 ==\n");

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if(cmd.equals("exit")){
                System.out.println("== motivation 종료 ==");
                break;
            } else if(cmd.isEmpty()) {
                System.out.println("명령어를 입력해주세요.");
                System.out.println("사용 가능한 명령어 목록이 필요하시다면, help를 입력해주세요.\n");
                continue;
            }

            if(cmd.equals("add")) {
                this.moId++;
                System.out.print("motivation : ");
                String motivation = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                System.out.printf("%d번 motivation이 등록되었습니다.\n\n", moId);
            } else if(cmd.equals("help")) {
                System.out.println("== 사용 가능한 명령어 목록 ==");
                System.out.println("add : 새로운 motivation을 등록합니다.");
                System.out.println("exit : motivation app을 종료합니다.\n");
            } else {
                System.out.println("올바른 명령어를 입력해주세요.");
                System.out.println("사용 가능한 명령어 목록이 필요하시다면, help를 입력해주세요.\n");

            }
        }
    }
}
