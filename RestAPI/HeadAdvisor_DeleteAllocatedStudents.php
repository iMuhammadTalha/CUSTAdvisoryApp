<?php
 require "dbconnection.php";
 
 $Advisor = $_POST["advisor_name"];
 $FirstStd = $_POST["first"]; 
 $LastStd = $_POST["last"];

 
 $sql_query = "DELETE FROM assigned_students WHERE First_student='$FirstStd' AND Last_student='$LastStd';";

 $sql_query2 = "UPDATE `advisors` SET `isApprove`='No' WHERE `Name`='$Advisor';";
 
 $result = mysqli_query($conn,$sql_query);
 
 

if($result>0)
{
	 mysqli_query($conn,$sql_query2);

		echo 'Deleted';
 

}
else
{
	echo 'Not';
}




$conn->close();
 ?>
