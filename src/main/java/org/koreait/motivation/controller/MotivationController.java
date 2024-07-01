package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.*;
import java.util.stream.Collectors;

public class MotivationController {
    private int lastId;
    private int motivationCount;
    private Map<Integer, Motivation> motivations;

    public MotivationController() {
        this.lastId = 0;
        this.motivationCount = 0;
        this.motivations = new HashMap<>();
    }

    public void editMotivation() {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없어 수정할 수 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            int willUpdate = getUsersInt(1);
            if (!motivations.containsKey(willUpdate)) System.out.printf("%d번 motivation은 존재하지 않습니다.\n", willUpdate);
            else {
                setNewMotivation(willUpdate);
            }
        }
    }

    public void editMotivation(String cmd) {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없어 수정할 수 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            int willUpdate = Integer.parseInt(cmd.substring(10));
            if (!motivations.containsKey(willUpdate)) System.out.printf("%d번 motivation은 존재하지 않습니다.\n", willUpdate);
            else {
                setNewMotivation(willUpdate);
            }
        }
    }

    public void setNewMotivation(int willUpdate) {
        Motivation updateMotivation = motivations.get(willUpdate);
        System.out.printf("%d번 motivation을 수정합니다.\n", willUpdate);
        System.out.println("body(기존) : " + updateMotivation.getBody());
        System.out.println("source(기존) : " + updateMotivation.getSource());
        System.out.println("수정하실 내용을 입력해주세요.");
        System.out.print("body : ");
        String newBody = Container.getScanner().nextLine();
        System.out.print("source : ");
        String newSource = Container.getScanner().nextLine();
        updateMotivation.setBody(newBody);
        updateMotivation.setSource(newSource);
        System.out.printf("%d번 motivation이 수정되었습니다.\n", willUpdate);
    }

    public void deleteMotivation() {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없어 삭제할 수 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            int willDelete = getUsersInt(2);
            if (!motivations.containsKey(willDelete)) System.out.printf("%d번 motivation은 존재하지 않습니다.\n", willDelete);
            else {
                motivations.remove(willDelete);
                System.out.printf("%d번 motivation이 삭제되었습니다.\n", willDelete);
                this.motivationCount--;
            }
        }
    }

    public void deleteMotivation(String cmd) {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없어 삭제할 수 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            int willDelete = Integer.parseInt(cmd.substring(10));
            if (!motivations.containsKey(willDelete)) System.out.printf("%d번 motivation은 존재하지 않습니다.\n", willDelete);
            else {
                motivations.remove(willDelete);
                System.out.printf("%d번 motivation이 삭제되었습니다.\n", willDelete);
                this.motivationCount--;
            }
        }
    }


    public void add() {
        this.lastId++;
        this.motivationCount++;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();
        Motivation newMo = new Motivation(this.lastId, body, source);
        this.motivations.put(this.lastId, newMo);
        System.out.printf("%d번 motivation이 등록되었습니다.\n", this.lastId);
    }

    public void list() {
        if (this.motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없습니다.");
            System.out.println("등록을 원하신다면 command에 add를 입력해주세요.");
            System.out.println("그 외의 명령어가 궁금하시다면, command에 help를 입력해주세요.");
        } else {
            System.out.printf("현재 등록된 motivation의 개수는 %d개 입니다.\n", this.motivationCount);
            System.out.println("======== motivation list ============");
            System.out.println("   id   //   source   //     body    ");
            System.out.println("=====================================");

            for (int i = this.lastId; i > 0; i--) {
                if (this.motivations.containsKey(i)) {
                    int myId = motivations.get(i).getMyId();
                    String displayBody = subForList(motivations.get(i).getBody(), "Body");
                    String displaySource = subForList(motivations.get(i).getSource(), "Source");
                    System.out.printf("   %d    //   %s   //   %s\n", myId, displaySource, displayBody);
                }
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
        System.out.println("delete : 등록된 motivation을 id 넘버를 통해 삭제합니다.");
        System.out.println("delete?id=(id) : (id)에 id값을 바로 넣어주세요. 해당 motivation을 바로 삭제합니다.");
        System.out.println("edit : 등록된 motivation을 id 넘버를 통해 수정합니다.");
        System.out.println("edit?id=(id) : (id)에 id값을 바로 넣어주세요. 해당 motivation을 바로 수정합니다.");
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

    public int getUsersInt(int delOrUp) {
        int usersInt;
        while(true) {
            try {
                switch (delOrUp) {
                    case 1:
                        System.out.print("수정하실 motivation의 id를 입력해주세요 : ");
                        break;
                    case 2:
                        System.out.print("삭제하실 motivation의 id를 입력해주세요 : ");
                        break;
                }
                usersInt = Container.getScanner().nextInt();
                Container.getScanner().nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수값을 입력해주세요.");
                Container.getScanner().nextLine();
            }
        }
        return usersInt;
    }
}


