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
public class Lecturer extends User{
    private int lecId;
    private String subjectsToTeach;
    private int roomNo;
    private int facultyId;

    /**
     * @return the subjectsToTeach
     */
    public String getSubjectsToTeach() {
        return subjectsToTeach;
    }

    /**
     * @param subjectsToTeach the subjectsToTeach to set
     */
    public void setSubjectsToTeach(String subjectsToTeach) {
        this.subjectsToTeach = subjectsToTeach;
    }

    /**
     * @return the roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @return the lecId
     */
    public int getLecId() {
        return lecId;
    }

    /**
     * @param lecId the lecId to set
     */
    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    /**
     * @return the facultyId
     */
    public int getFacultyId() {
        return facultyId;
    }

    /**
     * @param facultyId the facultyId to set
     */
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
    
}
