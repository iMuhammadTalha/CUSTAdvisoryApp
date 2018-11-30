<?php
 require "dbconnection.php";
 
 $titles = $_POST["title"];
 $descriptions = $_POST["description"]; 
 $headAdvisor = $_POST["user_name"];

 
 $sql_query = "INSERT INTO `announcement`(`Type`, `A_From`, `A_To`, `Title`, `Description`, `Date`) VALUES ('Advisors',(SELECT ID FROM users WHERE users.UserName='$headAdvisor'),'Advisors','$titles','$descriptions','2018-11-08');";

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
