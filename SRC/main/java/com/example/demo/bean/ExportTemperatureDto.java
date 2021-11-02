package com.example.demo.bean;


/**
 * @NAME: ExportTemperatureDto
 * @USER: WangJie
 * @DATE: 2021/10/12
 * @TIME: 15:54
 */

public class ExportTemperatureDto {
    private String name;
    private Double morningTemperature;
    private Double afternoonTemperature;
    private String classId;
    private String gradeId;
    private Integer personId;

    public ExportTemperatureDto(int i, String haha) {
        this.personId = i;
        this.name = haha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMorningTemperature() {
        return morningTemperature;
    }

    public void setMorningTemperature(Double morningTemperature) {
        this.morningTemperature = morningTemperature;
    }

    public Double getAfternoonTemperature() {
        return afternoonTemperature;
    }

    public void setAfternoonTemperature(Double afternoonTemperature) {
        this.afternoonTemperature = afternoonTemperature;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "ExportTemperatureDto{" +
                "name='" + name + '\'' +
                ", morningTemperature=" + morningTemperature +
                ", afternoonTemperature=" + afternoonTemperature +
                ", classId='" + classId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", personId=" + personId +
                '}';
    }
}
