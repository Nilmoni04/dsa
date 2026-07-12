import java.time.LocalTime;
import java.time.Duration;
class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        LocalTime t1 = LocalTime.parse(startTime);
        LocalTime t2 = LocalTime.parse(endTime);
        long seconds = Duration.between(t1,t2).getSeconds();
        return (int) seconds;
    }
}