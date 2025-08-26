import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("HH:mm");

    public String solution(int n, int t, int m, String[] timetable) {
        
        LocalTime base = LocalTime.parse("09:00", F);
        List<Bus> buses = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buses.add(new Bus(base.plusMinutes((long) i * t), m));
        }

        PriorityQueue<LocalTime> wait = new PriorityQueue<>();
        for (String s : timetable) {
            wait.offer(LocalTime.parse(s, F));
        }

        LocalTime lastBoardedOnLastBus = null;
        for (int i = 0; i < n; i++) {
            Bus bus = buses.get(i);
            int boarded = 0;

            while (boarded < bus.maxPassengers && !wait.isEmpty() && !wait.peek().isAfter(bus.departureTime)) {
                LocalTime passenger = wait.poll();
                boarded++;
                if (i == n - 1) lastBoardedOnLastBus = passenger;
            }

            bus.nowPassengers = boarded;

            if (i == n - 1) {
                if (bus.nowPassengers < bus.maxPassengers) {
                    return bus.departureTime.format(F);
                } else {
                    LocalTime cand = lastBoardedOnLastBus.minusMinutes(1);
                    if (cand.isBefore(LocalTime.MIDNIGHT)) cand = LocalTime.MIDNIGHT;
                    return cand.format(F);
                }
            }
        }
        return buses.get(n - 1).departureTime.format(F);
    }

    class Bus {
        final LocalTime departureTime;
        final int maxPassengers;
        int nowPassengers;

        Bus(LocalTime time, int max) {
            this.departureTime = time;
            this.maxPassengers = max;
            this.nowPassengers = 0;
        }

        boolean isAvailable() {
            return nowPassengers < maxPassengers;
        }
    }
}