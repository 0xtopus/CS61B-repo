public class LeapYear {
    public static void main(String[] args) {
        System.out.println("************* output below *************");
        int year = 2100;
        if(isLeapYear(year)) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is not a leap year!");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    } 
}