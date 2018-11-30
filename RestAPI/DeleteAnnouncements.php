<?php
 require "dbconnection.php";
 
 $Title = $_POST["title"];
 $Description = $_POST["description"]; 

 
 $sql_query = "DELETE FROM `announcement` WHERE Title='$Title' AND Description='$Description';";

 
 
 $result = mysqli_query($conn,$sql_query);
 
 

if($result>0)
{

		echo 'Deleted';
 

}
else
{
	echo 'Not';
}




$conn->close();
 ?>
