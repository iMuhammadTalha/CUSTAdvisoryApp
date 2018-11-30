<?php
 require "dbconnection.php";
 



 $sql_query = "SELECT advisors.Name, assigned_students.ID ,assigned_students.No_of_students, assigned_students.First_student, assigned_students.Last_student FROM advisors, assigned_students WHERE advisors.Department='SE' AND advisors.ID=assigned_students.Advisor_ID ORDER BY assigned_students.First_student;";

 $result = mysqli_query($conn,$sql_query);
 

if($result)
{
while($row=mysqli_fetch_array($result))
	{
	$flag[]=$row;
	}
print(json_encode($flag));
}




$conn->close();
 ?>
