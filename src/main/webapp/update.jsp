<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style >
body{
  background-image: url('ipl1.jpg');
   background-attachment: fixed;
  background-position: center;
  min-height : 100%;
  min-width : 100%;
  background-size:100% 100%;
  background-repeat:no-repeat;
  overflow-y: hidden;
  overflow-x: hidden;
}
.center1 {
  align : center;
   
  box-shadow: 7px 7px 5px grey;
	border-radius: 15px;
	margin-top: 10%;
	margin-left: 25%;
	margin-right: 40%;
  width: 50%;
  border: 3px solid green;
  padding: 20px;
  background: rgba(60, 179, 113, 0.85);
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class ="center1">
<form action="update.ghd" style="text-align: center">
		NEW TEAM CAPTAIN: <input type="text" name="newTeamCaptain"><br>
		<br> TEAM NAME : <input type="text" name="teamName">
		<br> <br> <input type="submit" value="SUBMIT">

	</form>
</div>


</body>
</html>