<%@ page import="java.util.List" %>
<%@ page import="model.City" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 23.01.2022
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="row">
    <div class="col-lg-8">

        <a class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addCity">Add city</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Code</th>

                <th scope="col">DETAILS</th>
            </tr>
            </thead>

            <tbody>
            <%
                List<City> list=(List<City>) request.getAttribute("cities");
                for(City city:list){


            %>
            <tr>
                <td><%=city.getId()%></td>
                <td><%=city.getName()%></td>
                <td><%=city.getCode()%></td>

                <td><a href="#" class="btn btn-info">DETAILS</a></td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>





    <!-- Modal -->
    <div class="modal fade" id="addCity" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add new city</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/addCity" method="post">
                        <div class="row mb-3">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">Name:</label>
                            <div class="col-sm-10">
                                <input type="text" name="cityName" class="form-control" id="inputEmail3">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="inputPassword3" class="col-sm-2 col-form-label">Code:</label>
                            <div class="col-sm-10">
                                <input type="text" name="cityCode" class="form-control" id="inputPassword3">
                            </div>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add city</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
