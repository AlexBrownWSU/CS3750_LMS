package appLayer;

import DAO.Entity.Averages;

public class AssignmentAverages {
    Averages averages;
    int aId;
    int cId;
    boolean results;

    public Averages getAverages() {
        return averages;
    }

    public void setAverages(Averages averages) {
        this.averages = averages;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public boolean isResults() {
        return results;
    }

    public void setResults(boolean results) {
        this.results = results;
    }
}
