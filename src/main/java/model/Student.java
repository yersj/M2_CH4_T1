package model;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String birthdate;
    private Long city_id;

    public Student(){}

    public Student(Long id, String name, String surname, String birthdate, Long city_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.city_id = city_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
