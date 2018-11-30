<?php
 require "dbconnection.php";
 
 $studentRegNo = $_POST["RegNo"];
 
// $studentRegNo = "bcs153044";
 
 $sql_query = "SELECT * FROM `students` WHERE students.RegNo='$studentRegNo';";

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
