import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("HH:mm");

    public String solution(int n, int t, int m, String[] timetable) {
        List<LocalTime> crews = new ArrayList<>(timetable.length);
        for (String s : timetable) crews.add(LocalTime.parse(s, F));
        Collections.sort(crews);

        List<Bus> buses = new ArrayList<>(n);
        LocalTime first = LocalTime.of(9, 0);
        for (int i = 0; i < n; i++) {
            buses.add(new Bus(first.plusMinutes((long) i * t), m));
        }

        int idx = 0;                   
        LocalTime lastBoarded = null;  

        for (int i = 0; i < n; i++) {
            Bus bus = buses.get(i);

            while (idx < crews.size() && bus.canBoard(crews.get(idx))) {
                lastBoarded = crews.get(idx);
                bus.board(lastBoarded);
                idx++;
            }

            if (i == n - 1) {
                if (bus.hasSeat()) {
                    return bus.depart.format(F);
                } else {
                    LocalTime cand = lastBoarded.minusMinutes(1);
                    if (cand.isBefore(LocalTime.MIDNIGHT)) cand = LocalTime.MIDNIGHT;
                    return cand.format(F);
                }
            }
        }

        return buses.get(n - 1).depart.format(F);
    }

    static class Bus {
        final LocalTime depart; 
        final int limit;        
        int count;              

        Bus(LocalTime depart, int limit) {
            this.depart = depart;
            this.limit = limit;
            this.count = 0;
        }

        boolean hasSeat() {
            return count < limit;
        }

        boolean canBoard(LocalTime crewArrive) {
            return !crewArrive.isAfter(depart) && hasSeat();
        }

        void board(LocalTime crewArrive) {
            count++;
        }
    }
}