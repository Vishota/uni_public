package com.example.time;

public class TimeInterval implements Comparable<TimeInterval> {
    private int seconds;
    private int minutes;
    private int hours;

    public TimeInterval(int seconds, int minutes, int hours) throws BadTimeException {
        this.fromSeconds(hours * 60 * 60 + minutes * hours + seconds);
    }
    public TimeInterval(int fullSeconds) throws BadTimeException {
        this.fromSeconds(fullSeconds);
    }

    public void fromSeconds(int fullSeconds) throws BadTimeException {
        if(fullSeconds < 0) throw new BadTimeException();
        this.hours = fullSeconds / 3600;
        fullSeconds -= this.hours * 3600;
        this.minutes = fullSeconds / 60;
        fullSeconds -= this.minutes * 60;
        this.seconds = fullSeconds;
    }

    public int calcSeconds () {
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    @Override
    public int compareTo(TimeInterval o) {
        return o.calcSeconds() - this.calcSeconds();
    }

    @Override
    public String toString() {
        return String.valueOf(hours) + "h " + String.valueOf(minutes) + "m " + String.valueOf(seconds) + "s";
    }
}
