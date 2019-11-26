package DAO.Entity;

public class assignmentAnalyntics {
    double max;
    double min;
    double avg;
    double median;
    double uGrade;

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getAvg() {
        return avg;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getuGrade() {
        return uGrade;
    }

    public void setuGrade(double uGrade) {
        this.uGrade = uGrade;
    }
}
