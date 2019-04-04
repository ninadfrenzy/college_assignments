
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel = "stylesheet" href = "style.css">
</head>
<body>



<%@ page import="java.sql.*"%>
<%@ page import ="javax.sql.*" %>
<%
String user=request.getParameter("uname");
//session.putValue("uname",user);
String pwd=request.getParameter("pwd");
String add1=request.getParameter("add1");
String add2=request.getParameter("add2");
String city=request.getParameter("city");
String state=request.getParameter("state");
String zip=request.getParameter("zip");


Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "mysql");

Statement st= con.createStatement();
ResultSet rs;
int i=st.executeUpdate("insert into users values('"+user+"','"+pwd+"','"+add1+"','"+add2+"', '"+city+"', '"+state+"','"+zip+"')");

%>

    <div class="title">
      <h1>Byte Sized Bytes</h1>
    </div>
    
    <div class="nav">
      <div class="left-side">
        <div class="nav-linker">
          <a href="news.html">Home</a>
        </div>
        <div class="nav-linker">
          <a href="about.html">About</a>
        </div>
      </div>
      <div class="right-side">
        <div class="nav-linker">
          <a href="login_form.html">Log in</a>
        </div>
        <div class="nav-linker">
          <a href="signup_form.html">Sign up</a>
        </div>
      </div>
    </div>
  <div class = "title">
    <p align = "center">Your response has been submitted!!!</p>
  </div>

</body>
</html>