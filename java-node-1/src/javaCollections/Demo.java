package javaCollections;
import java.util.HashMap;
import java.util.Map;
public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("河北", "石家庄");
        map.put("山西", "太原");
        map.put("辽宁", "沈阳");
        Map<String, String> newmap = Map.copyOf(map);
    }
}

