import java.util.*;
//import java.util.Arrays.*;

public class Main {

    public static void main(String args[]) {

        List<Meeting> mtgs = Arrays.asList(new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10));

        mergeRanges(mtgs);

    }

    
    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        Collections.sort(meetings);

        List<Meeting> merged = new ArrayList<Meeting>();

        Meeting newMeeting = meetings.get(0);

        for(int i = 1; i < meetings.size(); i++) {

            if (
                meetings.get(i).getStartTime() <= newMeeting.getEndTime() 
                &&
                meetings.get(i).getStartTime() >= newMeeting.getStartTime() 
            ) {

                newMeeting.setEndTime(Math.max(newMeeting.getEndTime(), meetings.get(i).getEndTime()));

            }

            else {

                merged.add(newMeeting);

                newMeeting = meetings.get(i); 

            }

        }

        merged.add(newMeeting);

        for (Meeting m : merged) {

            System.out.println(m.formattedStr());

        }

        return meetings;
    }

}