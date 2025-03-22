package javaProject1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class Pokergame {
    static Map<Integer, String> pokers = new HashMap<>();
    static ArrayList<Integer> pokerslist = new ArrayList<>();
    //准备牌
    static {
        String colors[] = {"♦","♣","♥","♠"};
        String numbers[] = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int num = 0;
        for(String number : numbers) {
            for(String color : colors) {
                pokers.put(num, color + number);
                pokerslist.add(num);
                num++;
            }
        }
        pokers.put(num, "小王");
        pokerslist.add(num);
        pokers.put(num + 1, "大王");
        pokerslist.add(num + 1);
    }
    public Pokergame() {

        Collections.shuffle(pokerslist);

        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> lord = new TreeSet<>();

        for (int i = 0; i < pokerslist.size(); i++) {
            if(i >= 51) {
                lord.add(pokerslist.get(i));
                continue;
            } 
            else if(i % 3 == 0) {
                player1.add(pokerslist.get(i));
            }
            else if(i % 3 == 1) {
                player2.add(pokerslist.get(i));
            }
            else {
                player3.add(pokerslist.get(i));
            }
        }
        lookpokers("玩家一", player1);
        lookpokers("玩家二", player2);
        lookpokers("玩家三", player3);
        lookpokers("底牌", lord);

    }
    public static void lookpokers(String name, TreeSet<Integer> treeset) {
        System.out.print(name + "的牌是：");
        for (Integer i : treeset) {
            System.out.print(pokers.get(i) + " ");
        }
        System.out.println();
    }
    public static void sortpokers() {
    }
}
