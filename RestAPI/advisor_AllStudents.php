<?php
 require "dbconnection.php";
 
 $advisorName = $_POST["user_name"];



 $sql_query = "SELECT students.id, students.RegNo, students.Name, students.U_GPA, students.U_CGPA, students.Phone, students.UG_Ernd FROM students,advisors,assigned_students WHERE advisors.Name='$advisorName' AND advisors.ID=assigned_students.Advisor_ID AND students.RegNo BETWEEN assigned_students.First_student AND assigned_students.Last_student ORDER BY RegNo;";

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
