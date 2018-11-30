<?php
 require "dbconnection.php";
 
 $studentRegNo = $_POST["user_name"];
 
// $studentRegNo = "bcs153044";
 
 $sql_query = "SELECT * FROM announcement, advisors, assigned_students, users WHERE announcement.Type='Student' AND announcement.A_To='Student' AND advisors.ID=assigned_students.Advisor_ID AND assigned_students.First_student<='$studentRegNo' AND assigned_students.Last_student>='$studentRegNo'AND users.ID=announcement.A_From AND advisors.Name =users.UserName;";

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
