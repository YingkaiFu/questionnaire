package com.questionnaire.demo.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class QuestionEntity {

    protected String index;

    protected String imageName;

    protected String imageName2;

    protected String name;

    protected String label;

    public QuestionEntity(String index, String imageName, String imageName2) {
        this.index = index;
        this.imageName = imageName;
        this.imageName2 = imageName2;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
