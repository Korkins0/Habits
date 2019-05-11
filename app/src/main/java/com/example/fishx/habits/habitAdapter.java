package com.example.fishx.habits;

public class habitAdapter {
    int id,streak,beststreak,notif;
    String habit;
    float happiness;

    public habitAdapter() {

    }

    public habitAdapter(String habit,int streak, int beststreak, int notif,  float happiness) {
        this.streak = streak;
        this.beststreak = beststreak;
        this.notif = notif;
        this.habit = habit;
        this.happiness = happiness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getBeststreak() {
        return beststreak;
    }

    public void setBeststreak(int beststreak) {
        this.beststreak = beststreak;
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public float getHappiness() {
        return happiness;
    }

    public void setHappiness(float happiness) {
        this.happiness = happiness;
    }
}
