package pawarv;

enum YesNo {
    YES, NO
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum DayNumber {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int dayNumber;

    DayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}


public class EnumDemo {
    public static void main(String[] args) {
        var yes = YesNo.YES;
        System.out.println(yes);

        var no = YesNo.NO;
        System.out.println(no);

        var day = Day.MONDAY;
        System.out.println(day);

        var dayNumber = DayNumber.MONDAY;
        System.out.println(dayNumber);
        System.out.println(dayNumber.getDayNumber());

        var dayNumber2 =  DayNumber.TUESDAY;
        System.out.println(dayNumber2);
        System.out.println(dayNumber2.getDayNumber());
    }

    
}
