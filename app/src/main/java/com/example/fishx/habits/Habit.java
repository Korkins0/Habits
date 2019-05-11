package com.example.fishx.habits;

import java.util.Date;

public class Habit {
    public Habit() {
    }

    public Habit(String habitName, boolean todayInput, int streak, int beststreak, float overallHappines, String generalInfo) {
        this.habitName = habitName;
        this.todayInput = todayInput;
        this.streak = streak;
        this.beststreak = beststreak;
        this.overallHappines = overallHappines;
        this.generalInfo = generalInfo;

    }
        
    String habitName;
    boolean todayInput;
    int streak;
    int beststreak;
    float overallHappines;
    String generalInfo;
    Date[] dates= new Date[]{};

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getBeststreak() {
        return beststreak;
    }

    public void setBeststreak(int beststreak) {
        this.beststreak = beststreak;
    }

    public float getOverallHappines() {
        return overallHappines;
    }

    public int getStreak() {
        return streak;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
    }

    public Date[] getDatesYouDid() {
        return dates;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    public void setOverallHappines(float overallHappines) {
        this.overallHappines = overallHappines;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setTodayInput(boolean todayInput) {
        this.todayInput = todayInput;
    }
}
