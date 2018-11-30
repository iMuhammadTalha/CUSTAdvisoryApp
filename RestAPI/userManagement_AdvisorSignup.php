<?php
 require "dbconnection.php";


 
$username = $_POST["advisor_regNo"];
$password = $_POST["advisor_password"];
$email = $_POST["advisor_email"];
$gender = $_POST["advisor_gender"];
$phone = $_POST["advisor_phone"];
$department = $_POST["advisor_department"];
$designation = $_POST["advisor_desigation"];



$activation=substr(md5(uniqid(rand(1,6))), 0, 4);        // Unique 4 Digit key for Activation Email

 
 $sql_query1 = "SELECT * FROM users WHERE UserName='$username'; ";
 $sql_query3 = "INSERT INTO users VALUES (null,'$username','$password','Advisor','$email','0','Yes');";
 
 $sql_query2 = "  INSERT INTO advisors VALUES (null,'$username','$gender','$email','$phone','$designation','$department','No');";
 
 $result1 = mysqli_query($conn,$sql_query1);


 
if(mysqli_num_rows($result1)>0)
{
	echo 'Sorry! This UserName has already account!';	
}
elseif(mysqli_query($conn,$sql_query2))
{	
	if(mysqli_query($conn,$sql_query3))
	{
		echo 'Account Create Successfully';
	}
	else
	{
		echo 'Error2';
	}
}
else
{
		echo 'Error3';
}

 
 
$conn->close();
 ?>
