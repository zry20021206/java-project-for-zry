package javaCrawler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Demo {
    public static void main(String[] args) {
        String str = "Java是世界上最好的语言";
        Pattern pattern = Pattern.compile("Java");
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            System.out.println("匹配成功");
            System.out.println(m.group());
        } else {
            System.out.println("匹配失败");
        } 
    }
}
