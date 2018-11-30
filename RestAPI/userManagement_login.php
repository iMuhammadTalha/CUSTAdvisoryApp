<?php
 require "dbconnection.php";
 
 $userName = $_POST["user_name"];
 $password = $_POST["user_password"];
 $role = $_POST["user_role"];


  $sql_query = "SELECT * FROM `users` WHERE `UserName`= '$userName' AND Password= '$password' AND Role= '$role' AND activation='Yes';";

 $result = mysqli_query($conn,$sql_query);
 
 if(mysqli_num_rows($result)>0)
{
	
	echo 'Login';
	
}
else {

	 echo 'Error User Name or Password not matched';
} 
$conn->close();
 ?>
