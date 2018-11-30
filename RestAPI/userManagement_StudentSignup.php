<?php
 require "dbconnection.php";


 
$regNo = $_POST["student_regNo"];
$password = $_POST["student_password"];
$email = $_POST["student_email"];

$activation=substr(md5(uniqid(rand(1,6))), 0, 4);        // Unique 4 Digit key for Activation Email

 
 $sql_query1 = "SELECT * FROM users WHERE UserName='$regNo'; ";
 $sql_query2 = "SELECT * FROM students WHERE RegNo='$regNo'; "; 
 $sql_query3 = "INSERT INTO users VALUES (null,'$regNo','$password','Student','$email','0','Yes');";
 
 $result1 = mysqli_query($conn,$sql_query1);
 $result2 = mysqli_query($conn,$sql_query2);


 
if(mysqli_num_rows($result1)>0)
{
	echo 'Sorry! This RegNo has already account!';	
}
elseif(mysqli_num_rows($result2)>0)
{
	if(mysqli_query($conn,$sql_query3))
	{
		echo 'Account Create Successfully';
	}
	else
	{
				echo 'Error';
	}
}
else
{
	echo 'This RegNo is not in Student list of our system';
}
 
 
$conn->close();
 ?>
