package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarMatching {
    public static void main(String[] args) {
        List<StringMeeting> calendar1 = Arrays.asList(
                new StringMeeting("9:00", "10:30"),
                new StringMeeting("12:00", "13:00"),
                new StringMeeting("16:00", "18:00")
                );
        StringMeeting dailyBounds1= new StringMeeting("9:00", "20:00");

        List<StringMeeting> calendar2 = Arrays.asList(
                new StringMeeting("10:00", "11:30"),
                new StringMeeting("12:30", "14:30"),
                new StringMeeting("14:30", "15:00"),
                new StringMeeting("16:00", "17:00")
        );
        StringMeeting dailyBound2= new StringMeeting("10:00", "18:30");
        int meetingDuration= 30;

        System.out.println(calendarMatching(calendar1, dailyBounds1, calendar2, dailyBound2, meetingDuration));
    }
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {

        List<Integer[]> cal1Mins= new ArrayList<>();
        List<Integer[]> cal2Mins= new ArrayList<>();
        conversions(calendar1, cal1Mins);
        conversions(calendar2, cal2Mins);

        List<Integer[]> mergesCalenders= mergesCalenders(cal1Mins, cal2Mins);
        List<Integer[]> flattenCalender= flattenCalender(mergesCalenders);
        List<StringMeeting> result = getTime(flattenCalender,meetingDuration);

                //backToTimeFormat(mergesCalenders);
        return new ArrayList<>();
    }

    static  List<StringMeeting> getTime(List<Integer[]> flattenCalender, int meetingDuration){
        List<StringMeeting> result = new ArrayList<>();
        for (int i=1;i < flattenCalender.size(); i++){
            int prevEnd = flattenCalender.get(i-1)[1];
            int currStart = flattenCalender.get(i)[0];
            if (meetingDuration<= (currStart-prevEnd)){
                result.add(
                        convertToTime(new Integer[]{prevEnd, currStart})
                );
            }
        }
        return result;
    }
    static StringMeeting convertToTime(Integer[] time ){
        int startHour = time[0]/60;
        int startMin = time[0]%60;
        String startMinString = startMin<10 ?"0"+startMin : Integer.toString(startMin);
        String startStr = startHour+":"+startMinString;

        int endHour = time[0]/60;
        int endMin = time[0]%60;
        String endMinString = endMin<10 ?"0"+endMin : Integer.toString(endMin);
        String endStr = endHour+":"+endMinString;
        StringMeeting s = new StringMeeting(startStr, endStr);
        return s;
    }

    static List<Integer[]> flattenCalender(List<Integer[]> mergesCalenders){
        List<Integer[]> flattened= new ArrayList<>();
        flattened.add(mergesCalenders.get(0));
        for (int i=1; i < mergesCalenders.size(); i++){
            Integer[] currentMeeting = mergesCalenders.get(i);
            Integer[] previousMeeting = flattened.get(flattened.size()-1);
            if (currentMeeting!=null && previousMeeting!=null && previousMeeting[1]>=currentMeeting[0]){
                Integer[] newPrevMeeting = new Integer[]{
                    previousMeeting[0], Math.max(previousMeeting[1],currentMeeting[1])
                };
                flattened.set(flattened.size()-1, newPrevMeeting);
            }else{
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }
    static List<StringMeeting> backToTimeFormat(List<Integer[]>bookedTimings ){
        List<StringMeeting> mergedTime= new ArrayList<>();
        for (Integer[] array : bookedTimings){
            mergedTime.add(convertToTime(array));
        }
        return mergedTime;
    }

    static List<Integer[]> mergesCalenders (List<Integer[]> bookedTime1, List<Integer[]> bookedTime2){
        List<Integer[]> mergedTime = new ArrayList<>();
        int i= 0, j=0;
        while (i<bookedTime1.size() && j< bookedTime2.size()){
            int start1= bookedTime1.get(i)[0];
            int end1= bookedTime1.get(i)[1];
            int start2 = bookedTime2.get(j)[0];
            int end2 = bookedTime2.get(j)[1];
            if ( start1< start2 ){
                mergedTime.add(new Integer[]{start1, end1});
                i++;
            }else {
                mergedTime.add(new Integer[]{start2, end2});
                j++;
            }
        }
        while (i<bookedTime1.size()){
            int start1= bookedTime1.get(i)[0];
            int end1= bookedTime1.get(i)[1];
            mergedTime.add(new Integer[]{start1, end1});
            i++;
        }
        while (j< bookedTime2.size()){
            int start2 = bookedTime2.get(j)[0];
            int end2 = bookedTime2.get(j)[1];
            mergedTime.add(new Integer[]{start2, end2});
            j++;
        }
        return mergedTime;
    }


    static void conversions(List<StringMeeting> stringMeetings, List<Integer[]> minList){
        for (int i=0; i < stringMeetings.size(); i++){
            minList.add( new Integer[]{convertsToMins(stringMeetings.get(i).start), convertsToMins(stringMeetings.get(i).end) });
        }
    }

    public static Integer convertsToMins(String time){
        String[] array= time.split(":");
        Integer mins = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
        return mins;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
