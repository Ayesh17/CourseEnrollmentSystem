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
public class Subject {
    private int subjectCode;
    private String subjectName;
    private double fee;
    private boolean isMandatory;
    private String lecturers;
    private String instructors;
    private int courseCode;

    public Subject() {
    }

    
    /**
     * @return the subjectCode
     */
    public int getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode the subjectCode to set
     */
    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the isMandatory
     */
    public boolean isIsMandatory() {
        return isMandatory;
    }

    /**
     * @param isMandatory the isMandatory to set
     */
    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
     * @return the lecturers
     */
    public String getLecturers() {
        return lecturers;
    }

    /**
     * @param lecturers the lecturers to set
     */
    public void setLecturers(String lecturers) {
        this.lecturers = lecturers;
    }

    /**
     * @return the instructors
     */
    public String getInstructors() {
        return instructors;
    }

    /**
     * @param instructors the instructors to set
     */
    public void setInstructors(String instructors) {
        this.instructors = instructors;
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
    
    
}
