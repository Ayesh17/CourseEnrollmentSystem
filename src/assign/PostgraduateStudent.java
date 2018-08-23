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
public class PostgraduateStudent extends User {
    private String postgraduateId;
    private String undergraduateDegree;
    private String University;
    private int yearOfGraduation;
    private String qualificationType;
    private int courseCode;
    private String intake;

    /**
     * @return the undergraduateDegree
     */
    public String getUndergraduateDegree() {
        return undergraduateDegree;
    }

    /**
     * @param undergraduateDegree the undergraduateDegree to set
     */
    public void setUndergraduateDegree(String undergraduateDegree) {
        this.undergraduateDegree = undergraduateDegree;
    }

    /**
     * @return the University
     */
    public String getUniversity() {
        return University;
    }

    /**
     * @param University the University to set
     */
    public void setUniversity(String University) {
        this.University = University;
    }

    /**
     * @return the yearOfGraduation
     */
    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    /**
     * @param yearOfGraduation the yearOfGraduation to set
     */
    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
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

    /**
     * @return the qualificationType
     */
    public String getQualificationType() {
        return qualificationType;
    }

    /**
     * @param qualificationType the qualificationType to set
     */
    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    /**
     * @return the courseCode
     */
    public int getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the intake
     */
    public String getIntake() {
        return intake;
    }

    /**
     * @param intake the intake to set
     */
    public void setIntake(String intake) {
        this.intake = intake;
    }
}
