/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign;

/**
 *
 * @author Ayesh
 */
public class UndergraduateExam extends Exam{
    private String undergraduateId;
    private double examPercentage;

    public UndergraduateExam() {
    }

    /**
     * @return the undergraduateId
     */
    public String getUndergraduateId() {
        return undergraduateId;
    }

    /**
     * @param undergraduateId the undergraduateId to set
     */
    public void setUndergraduateId(String undergraduateId) {
        this.undergraduateId = undergraduateId;
    }

    /**
     * @return the examPercentage
     */
    public double getExamPercentage() {
        return examPercentage;
    }

    /**
     * @param examPercentage the examPercentage to set
     */
    public void setExamPercentage(double examPercentage) {
        this.examPercentage = examPercentage;
    }
    
    
}
