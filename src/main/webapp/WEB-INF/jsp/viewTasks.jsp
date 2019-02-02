<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Form Handling</title>

<script type="text/javascript">
    function submitForm() {
        var ext = document.getElementById('ext');
        var selected_opt = ext.options[ext.selectedIndex].value;
        document.getElementById("myForm").action=document.getElementById("myForm").action+selected_opt;
        document.getElementById('myForm').submit();
    }
</script>
</head>

<body bgcolor="AliceBlue" align="center" style="display:block;font-weight:bold;font-family:verdana">
	<h2>View All Tasks</h2>
<form:form id="myForm" method = "GET" action = "/viewTasks/">
         <table align="center">
            <tr>
               <td><form:label path = "projectBelonged">project</form:label></td>
	               <td>
	               <form:select path = "projectBelonged" id = "ext" onchange="submitForm()">
					   <form:option value = "NONE" label = "Select"/>
					   <form:options items = "${projectList}" itemValue="projectId" itemLabel="projectName"/>
					</form:select> 
					</td>
            </tr>
                     </table align="center">  
      </form:form>
	<c:forEach var="task" items="${allTasks}">
		<table>
			<tr>
				<td>${task.taskId}</td>
				<td>${task.taskName}</td>
				<td>${task.taskStartDate}</td>
				<td>${task.taskEnddate}</td>
			</tr>

		</table>
	</c:forEach>


	<a href="/">Go Back</a>
</body>

</html>