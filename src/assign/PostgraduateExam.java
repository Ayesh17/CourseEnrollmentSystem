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
public class PostgraduateExam extends Exam{
    private String postgraduateId;
    private double examPercentage;

    public PostgraduateExam() {
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

    /**
     * @return the postgraduateId
     */
    public String getPostgraduateId() {
        return postgraduateId;
    }

    /**
     * @param postgraduateId the postgraduateId to set
     */
    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }
    
    
}
