package javaComprehensive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "石家庄", "衡水", "保定");
        Map<String, List<String>> hashmap = new HashMap<>();
        hashmap.put("河北省", list);
        for (Map.Entry<String, List<String>> entry : hashmap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (String s : entry.getValue()) {
                sb.append(s + " ");
            }
            System.out.println(entry.getKey() + "：" + sb);
        }
    }
}
