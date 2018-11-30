<?php
 require "dbconnection.php";
 
 $advisor = $_POST["user_name"];
 
 
 $sql_query = "SELECT * FROM `announcement` WHERE `A_From`=(SELECT ID FROM users WHERE users.UserName='$advisor');";

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
