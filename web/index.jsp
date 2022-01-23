<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="db.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 20.01.2022
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="container">

    <div class="row">
        <div class="col-lg-12 m-auto">
            <form action="/addStudent" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">NAME:</label>
                    <input type="text" name="name" class="form-control" id="name" >
                </div>

                <div class="mb-3">
                    <label for="surname" class="form-label">SURNAME:</label>
                    <input type="text" name="surname" class="form-control" id="surname" >
                </div>

                <div class="mb-3">
                    <label for="birthdate" class="form-label">BIRTHDATE:</label>
                    <input type="date" name="birthdate" class="form-control" id="birthdate" >
                </div>

                <div class="mb-3">
                    <label for="city" class="form-label">CITY:</label>
                    <select name="city" id="city">
                        <option value="1">Almaty</option>
                        <option value="2">Astana</option>
                        <option value="3">Dubai</option>
                        <option value="4">Madrid</option>
                        <option value="5">Taraz</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-success">ADD STUDENT</button>
            </form>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Birthdate</th>
                    <th scope="col">City</th>
                    <th scope="col">DETAILS</th>
                </tr>
                </thead>
                <tbody>

                    <%
                    List<Student> list=(List<Student>) request.getAttribute("students");
                    for(Student student:list){


                    %>


                    <td><%=student.getId()%></td>
                    <td><%=student.getName()%></td>
                    <td><%=student.getSurname()%></td>
                    <td><%=student.getBirthdate()%></td>
                    <td><%=DBManager.getCityById(student.getCity_id())%></td>
                    <td><a href="/details?studentId=<%=student.getId()%>" class="btn btn-info">DETAILS</a></td>

                </tr>
                  <%
                      }
                  %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
