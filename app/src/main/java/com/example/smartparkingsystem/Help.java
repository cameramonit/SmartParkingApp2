package com.example.smartparkingsystem;

public class Help {
    //method start
    public static String convertHoursToMinutes(String time) {
        try {
            if (time.charAt(0) == '0' && time.charAt(3) == '0') {
                time = String.valueOf(Integer.parseInt(String.valueOf(time.charAt(1))) * 60 + Integer.parseInt(String.valueOf(time.charAt(4))));
            } else if (time.charAt(0) != '0' && time.charAt(3) == '0') {
                time = String.valueOf(Integer.parseInt(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1))) * 60 + Integer.parseInt(String.valueOf(time.charAt(4))));
            } else if (time.charAt(0) == '0' && time.charAt(3) != '0') {
                time = String.valueOf(Integer.parseInt(String.valueOf(time.charAt(1))) * 60 + Integer.parseInt(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4))));
            } else if (time.charAt(0) != '0' && time.charAt(3) != '0') {
                time = String.valueOf(Integer.parseInt(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1))) * 60 + Integer.parseInt(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4))));
            } else {
                System.err.println("ERROR");
            }
        } catch (Exception e) {
            System.err.println("ERROR");
        }

        return time;
    }
}
