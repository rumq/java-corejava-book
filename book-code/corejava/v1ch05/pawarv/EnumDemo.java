package pawarv;

enum YesNo {
    YES, NO
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
public class EnumDemo {
    public static void main(String[] args) {
        var yes = YesNo.YES;
        System.out.println(yes);

        var no = YesNo.NO;
        System.out.println(no);

        var day = Day.MONDAY;
        System.out.println(day);
    }
    
}
