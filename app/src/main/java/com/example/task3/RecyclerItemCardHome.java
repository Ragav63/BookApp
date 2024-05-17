package com.example.task3;

public class RecyclerItemCardHome {
    //Recycler Items for card(Subjects) in Home Fragment

    private String subjectCardTitle;

    public RecyclerItemCardHome(String subjectCardTitle) {
        this.subjectCardTitle = subjectCardTitle;
    }


    public String getSubjectCardTitle() {
        return subjectCardTitle;
    }

    public void setSubjectCardTitle(String subjectCardTitle) {
        this.subjectCardTitle = subjectCardTitle;
    }
}
