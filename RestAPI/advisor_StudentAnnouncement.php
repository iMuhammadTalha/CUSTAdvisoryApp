<?php
 require "dbconnection.php";
 
 $titles = $_POST["title"];
 $descriptions = $_POST["description"]; 
 $advisorName = $_POST["user_name"];

 
 $sql_query = "INSERT INTO announcement (`Type`, `A_From`, `A_To`, `Title`, `Description`, `Date`) VALUES ('Student',(SELECT ID FROM users WHERE users.UserName='$advisorName'),'Student','$titles','$descriptions','2018-11-08');";

 $result = mysqli_query($conn,$sql_query);
 
 

if($result>0)
{
		echo 'Added';

}
else
{
	echo 'Not';
}




$conn->close();
 ?>
