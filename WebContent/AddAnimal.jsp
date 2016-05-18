<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Animal</title>
<style>

a:link, a:visited {
	width: 150px;
    background-color: Black;
    color: skyblue;
    padding: 14px 25px;
    text-align: center;	
    text-decoration: none;
    display: inline-block;
}
.center {
    margin: auto;
    width: 25%;
    
    padding: 10px;
}

a:hover, a:active {
    background-color: green;
}


body {
    background-color: #D0D0D0 ;
}
</style>
</head>
<body>
	<form id="form1" name="form1" method="post" action="/Assignment/AddAnimal">
	<a href="/Assignment/GameServlet">Play Again</a>
	<table width="532" border="0" align="center">
	
	 <tr>
        <td width="257" align="center">Animal Name</td>
        <td width="259" align="center"><label>
          <input type="text" name="name" id="name" />
        </label></td>
      </tr>
      <tr>
        <td width="257" align="center">Animal Description</td>
        <td width="259" align="center"><label>
          <textarea name="description" id="description" rows="2" cols="50"></textarea>
        </label></td>
      </tr>
      
      <tr>
        <td>&nbsp;</td>
        <td align="center"><label>
          <input name="profile" type="submit"  id="profile" value="Submit" />
        </label></td>
      </tr>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
		</c:if>
      </table>
      </form>
</body>
</html>