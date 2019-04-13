public class MyAtoi {

    public int atoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int base = 0;
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.atoi("-123r4"));
        System.out.println(myAtoi.atoi("asvc1"));
        System.out.println(myAtoi.atoi("1234rf3"));
        System.out.println(
                String.valueOf(Integer.MAX_VALUE + 100)
        );
        System.out.println(myAtoi.atoi(
                String.valueOf(Integer.MAX_VALUE  / 10 + 10)));
        System.out.println(myAtoi.atoi(" -+4 2"));
        System.out.println("42");

    }
}
