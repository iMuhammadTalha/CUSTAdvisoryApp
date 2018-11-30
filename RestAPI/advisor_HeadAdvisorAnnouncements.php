<?php
 require "dbconnection.php";
 
 $advisorName = $_POST["user_name"];
 
//$advisorName = "Faheem";
 
 $sql_query = "SELECT * FROM announcement WHERE announcement.Type='Advisors' AND announcement.A_To='All Departments' OR announcement.A_To=(SELECT advisors.Department FROM advisors WHERE advisors.Name='$advisorName');";

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
