package db;

import model.City;
import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static Connection connection;

    public static void getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/univer?useUnicode=true&serverTimezone=UTC","root","");
            System.out.println("connected!!!");
        }catch (Exception e){e.printStackTrace();}

    }

    public static List<Student> getAllStudents(){
        List<Student> list= new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement("select *from students");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                String birthdate=resultSet.getString("birthdate");
                Long city_id=resultSet.getLong("city_id");
            list.add(new Student(id,name,surname,birthdate,city_id));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void addStudent(Student student){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into students values(null,?,?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3,student.getBirthdate());
            statement.setLong(4,student.getCity_id());
            statement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }

    public static Student getById(Long id){
        Student student=new Student();
        try {
            PreparedStatement statement=connection.prepareStatement("select * from students where id=?");
            statement.setLong(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                student=new Student(id,
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birthdate"),
                        resultSet.getLong("city_id"));
            }
        }catch (Exception e){e.printStackTrace();}
        return student;
    }
    public static String getCityById(Long id){
        String city=null;
        try {
            PreparedStatement statement=connection.prepareStatement(
                    "select cities.name,cities.code from students join cities  on(students.city_id = cities.id) where cities.id=?");
            statement.setLong(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                city=resultSet.getString("name");
                city=city+"-"+resultSet.getString("code");
            }
        }catch (Exception e){e.printStackTrace();}
         return city;
    }

    public static void updateStudent(Student student){
        try {
            PreparedStatement statement=connection.prepareStatement("update students set name=?,surname=?,birthdate=?,city_id=?   where id=? ;");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setString(3,student.getBirthdate());
            statement.setLong(4, student.getCity_id());
            statement.setLong(5,student.getId());
            statement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }

    public static void deleteStudent(Long id){
        try {
            PreparedStatement statement=connection.prepareStatement("delete from students where id=?");
            statement.setLong(1,id);
            statement.executeUpdate();

        }catch (Exception e){e.printStackTrace();}
    }
    public static List<City> getCities(){
        List<City> list=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("select *from cities");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
             Long id=resultSet.getLong("id");
             String name=resultSet.getString("name");
             String code=resultSet.getString("code");
             list.add(new City(id,name,code));
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }

    public static void addCity(City city){
        try {
            PreparedStatement statement=connection.prepareStatement("insert into cities values(null,?,?)");
            statement.setString(1,city.getName());
            statement.setString(2,city.getCode());
            statement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }
}
