package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Comparator;

/*
Time Complexity: O(n) to iterate through every position and insert them in a data structure.
                 O(n log n)  to sort the data structure in ascending order of end time.
                 O(n)  to iterate through the positions and check which meeting can be performed.
                 Overall : O(n) +O(n log n) + O(n) ~O(n log n)
Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.
*/
// refer: https://takeuforward.org/data-structure/n-meetings-in-one-room/

public class N_meetings_in_a_room {
    public static void main(String[] args) {
        int N = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println("Max meetings: " + maxMeetings(start, end, N));
    }

    private static int maxMeetings(int[] start, int[] end, int n) {

        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new Meeting(start[i], end[i], i + 1));
        }

        list.sort(new meetComparator());

        int count = 1;

        int endLimit = list.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (list.get(i).start > endLimit) {
                endLimit = list.get(i).end;
                count++;
            }
        }

        return count;
    }
}

class Meeting {
    int start, end, pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetComparator implements Comparator<Meeting> {
    public int compare(Meeting m1, Meeting m2) {
        if (m1.end < m2.end)
            return -1;
        else if (m1.end > m2.end)
            return 1;
        else if (m1.pos < m2.pos)
            return -1;

        return 0;
    }
}