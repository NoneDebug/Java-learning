// 将字符串中指定部分进行翻转
// 编写方法 public static String reverse(String str, int start, int end) 搞定
public class Homework01 {
    public static void main(String[] args) {
        String s1 = new String("abcdef");
        System.out.println(s1);
        s1 = reverse(s1, 1, 4);
        System.out.println(s1);
    }

    public static String reverse(String s, int low, int high) {
        if (low < 0 || high > s.length() || low > high) {
            return s;
        }
        char[] arr = s.toCharArray();
        while (low < high) {
            char tempChar = arr[low];
            arr[low] = arr[high];
            arr[high] = tempChar;
            low++;
            high--;
        }
        return new String(arr);
    }
}
