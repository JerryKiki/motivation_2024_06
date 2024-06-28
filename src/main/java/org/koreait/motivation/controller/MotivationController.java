package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    private int lastId;
    private List<Motivation> motivations;

    public MotivationController() {
        this.lastId = 0;
        this.motivations = new ArrayList<>();
    }

    public void add() {
        this.lastId++;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();
        Motivation newMo = new Motivation(this.lastId, body, source);
        this.motivations.add(newMo);
        System.out.printf("%d번 motivation이 등록되었습니다.\n", this.lastId);
    }

    public void list() {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            System.out.printf("현재 등록된 motivation의 개수는 %d개 입니다.\n", this.lastId);
            System.out.println("======== motivation list ============");
            System.out.println("   id   //   source   //     body    ");
            System.out.println("=====================================");

            for (int i = this.lastId - 1; i >= 0; i--) {
                int nowId = motivations.get(i).getMyId();
                String displayBody = subForList(motivations.get(i).getBody(), "Body");
                String displaySource = subForList(motivations.get(i).getSource(), "Source");
                System.out.printf("   %d    //   %s   //   %s\n", nowId, displaySource, displayBody);
            }
        }
    }

    String subForList(String willSub, String thisCase) {
        String subedString = willSub;

        switch (thisCase) {
            case "Source":
                if (willSub.length() > 3) {
                    subedString = willSub.substring(0, 3) + "...";
                } else if (willSub.length() == 3) subedString = willSub + "   ";
                else if (willSub.length() == 2) subedString = willSub + "    ";
                else if (willSub.length() == 1) subedString = willSub + "     ";
                break;
            case "Body":
                if (willSub.length() > 7) {
                    subedString = willSub.substring(0, 7) + "...";
                }
                break;
        }

        return subedString;
    }

    public void help() {
        System.out.println("== 사용 가능한 명령어 목록 ==");
        System.out.println("help : 사용 가능한 명령어 목록을 불러옵니다.");
        System.out.println("add : 새로운 motivation을 등록합니다.");
        System.out.println("list : 등록된 motivation의 목록을 불러옵니다.");
        System.out.println("exit : motivation app을 종료합니다.");
    }

    public void notice(int i) {
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

