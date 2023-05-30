package src;

public class AnalysisResult {
    private Patient patient;
    private boolean h1n1;
    private boolean rhinovirus;
    private boolean sarscov2;
    private boolean insuline;
    private boolean bloodpres;
    private boolean escColi;
    private boolean clostTetani;
    private boolean hiv;

    public AnalysisResult(Patient patient, boolean h1n1, boolean rhinovirus, boolean sarscov2, boolean insuline, boolean bloodpres, boolean escColi, boolean clostTetani, boolean hiv) {
        this.patient = patient;
        this.h1n1 = h1n1;
        this.rhinovirus = rhinovirus;
        this.sarscov2 = sarscov2;
        this.insuline = insuline;
        this.bloodpres = bloodpres;
        this.escColi = escColi;
        this.clostTetani = clostTetani;
        this.hiv = hiv;
    }

    public AnalysisResult(Patient p)
    {
        patient = p;
        this.h1n1 = false;
        this.rhinovirus = false;
        this.sarscov2 = false;
        this.insuline = false;
        this.bloodpres = false;
        this.escColi = false;
        this.clostTetani = false;
        this.hiv = false;

    }

    public boolean isH1n1() {
        return h1n1;
    }

    public void setH1n1(boolean h1n1) {
        this.h1n1 = h1n1;
    }

    public boolean isRhinovirus() {
        return rhinovirus;
    }

    public void setRhinovirus(boolean rhinovirus) {
        this.rhinovirus = rhinovirus;
    }

    public boolean isSarscov2() {
        return sarscov2;
    }

    public void setSarscov2(boolean sarscov2) {
        this.sarscov2 = sarscov2;
    }

    public boolean isInsuline() {
        return insuline;
    }

    public void setInsuline(boolean insuline) {
        this.insuline = insuline;
    }

    public boolean isBloodpres() {
        return bloodpres;
    }

    public void setBloodpres(boolean bloodpres) {
        this.bloodpres = bloodpres;
    }

    public boolean isEscColi() {
        return escColi;
    }

    public void setEscColi(boolean escColi) {
        this.escColi = escColi;
    }

    public boolean isClostTetani() {
        return clostTetani;
    }

    public void setClostTetani(boolean clostTetani) {
        this.clostTetani = clostTetani;
    }

    public boolean isHiv() {
        return hiv;
    }

    public void setHiv(boolean hiv) {
        this.hiv = hiv;
    }

    public String display() {
        return patient.toString() + '\'' +
                ", H1N1 =" + h1n1 + '\'' +
                ", Rhinovirus = " + rhinovirus + '\'' +
                ", SARS-CoV-2 = " + sarscov2 + '\'' +
                ", Insulin Resistance = " + insuline + '\'' +
                ", High Blood Pressure = " + bloodpres + '\'' +
                ", Escherichia Coli = " + escColi + '\'' +
                ", Clostridium Tetani = " + clostTetani + '\'' +
                ", HIV = " + hiv;
    }
}