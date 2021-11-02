package com.example.demo;

public class wj {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book : bookings) {
            res[book[0] - 1] += book[2];
            if (book[1] < n) {
                res[book[1]] -= book[2];
            }
        }

        for (int j = 1; j < n; ++j) {
            res[j] += res[j - 1];
        }
        return res;
    }
}