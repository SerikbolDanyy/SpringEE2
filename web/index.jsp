<%@ page import="java.util.List" %>
<%@ page import="Connector.Item" %>
<%@ page import="Database.ItemDB" %><%--
  Created by IntelliJ IDEA.
  User: serik
  Date: 17.02.2024
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    <title>Main Page</title>
</head>
<body>
    <div class="container">
        <%@include file="navBar.jsp"%>
        <br>
        <h1 class="text-center">Welcome to Bitlab Shop</h1>
        <p class="text-center" style="color: darkgray">Cheapest tech market with high quality</p>
        <br><br>
        <div class="row">
            <% List<Item> items = ItemDB.getAllItems();
                for (Item item: items){
            %>
            <div class="col-4">

           <div class="card">
            <div class="card-header">
                <%=item.getName()%>
            </div>
            <div class="card-body">
                <h5 class="card-title"><%=item.getPrice()%></h5>
                <p class="card-text"><%=item.getDescription()%></p>
                <a href="/detailItem?id=<%=item.getId()%>" class="btn btn-primary">Details</a>
            </div>
        </div>

            </div>
            <%}%>
        </div>
        <br><br>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
           + Add item
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add item</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/addItem" method="post">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Name:</label>
                                <input name="name" type="text" class="form-control" id="2" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Description:</label>
                                <input name="description" type="text" class="form-control" id="1" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Price:</label>
                                <input name="price" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
