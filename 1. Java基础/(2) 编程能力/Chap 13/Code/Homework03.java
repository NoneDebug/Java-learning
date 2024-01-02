public class Homework03 {
    public static void main(String[] args) {
        String name = "tang yu bo";
        printName(name);
    }
    public static void printName(String str){
        if(str == null){
            System.out.println("str 不能为空");
        }
            String[] names = str.split(" ");
            if(names.length != 3){
                System.out.println("输入的格式不对");
                return;
            }
            String format = String.format("%s,%s .%c", names[1], names[2], names[0].toUpperCase().charAt(0));
            System.out.println(format);

    }
}
