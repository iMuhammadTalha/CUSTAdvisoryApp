<?php
 require "dbconnection.php";
 
 $studentRegNo = $_POST["user_name"];
 
// $studentRegNo = "bcs153044";
 
 $sql_query = "SELECT * FROM advisors,assigned_students WHERE advisors.ID=assigned_students.Advisor_ID AND assigned_students.First_student<='$studentRegNo' AND assigned_students.Last_student>='$studentRegNo';";

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
