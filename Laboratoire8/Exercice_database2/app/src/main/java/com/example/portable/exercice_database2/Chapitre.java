package com.example.portable.exercice_database2;


public class Chapitre {
    private int id;
    private String name;
    private String description;

    public Chapitre(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Chapitre( String name, String description) {

        this.name = name;
        this.description = description;
    }
    public Chapitre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chapitre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
