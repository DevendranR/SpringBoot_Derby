<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
      </head>

   <body bgcolor="AliceBlue" align="center" style="display:block;font-weight:bold;font-family:verdana">
      <h2>Task Information</h2>
      <form:form method = "POST" action = "/addTask">
         <table align="center">
            <tr>
               <td><form:label path = "taskName">Name</form:label></td>
               <td><form:input path = "taskName" /></td>
            </tr>
            <tr>
               <td><form:label path = "taskStartDate">taskStartDate  - please enter in dd-MM-yyyy format</form:label></td>
               <td><form:input path="taskStartDate" size="15" /></td>
            </tr>
            <tr>
               <td><form:label path = "taskEnddate">taskEnddate - please enter in dd-MM-yyyy format</form:label></td>
               <td><form:input path="taskEnddate" size="15" /></td>
            </tr>
            
            <tr>
               <td><form:label path = "projectBelonged">project</form:label></td>
	               <td>
	               <form:select path = "projectBelonged" id = "projectSelected" onchange="fetchEmployees(this)">
					   <form:option value = "NONE" label = "Select"/>
					   <form:options items = "${projectList}" itemValue="projectId" itemLabel="projectName"/>
					</form:select> 
					</td>
            </tr>
            <tr>
               <td><form:label path = "employeesAssigned">employees</form:label></td>
	               <td>
	               <form:select path="employeesAssigned" multiple="multiple" id = "employeesToBeAssigned">
					
					
					</form:select> 
					</td>
            </tr>
            
            
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
         
	<a href="/">Go Back</a>
      </form:form>

   <script type="text/javascript">
   	function fetchEmployees(object){
   		var projectId = object.value;
   		$.ajax({
	        type: 'GET',
	        url: "/employeesList/" + projectId,
	        success: function(data){
	            var employeesAssigned=$('#employeesToBeAssigned'), option="";
	            employeesAssigned.empty();
	            var empObj = JSON.parse(data);
	            for(var i=0; i<empObj.length; i++){
	                option = option + "<option value='"+empObj[i].employeeId + "'>"+empObj[i].employeeName + "</option>";
	            }
	            employeesAssigned.append(option);
	        },
	        error:function(){
	            alert("error");
	        }

	    });
   	}
      </script>      
   
   </body>
   
</html>