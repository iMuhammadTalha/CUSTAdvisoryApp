<?php
 require "dbconnection.php";
 
 //$email = $_POST["user_email"];
$email = "muhammadtalha3810@gmail.com";



  $sql_query = "SELECT * FROM `users` WHERE `email`= '$email';";

 $result = mysqli_query($conn,$sql_query);
 
 if(mysqli_num_rows($result)>0)
{
	
			$reset_key=substr(md5(uniqid(rand(1,6))), 0, 4);        // Unique 4 Digit key for reset password
            
			 $sql_query1 = "UPDATE users SET reset_password_key='$reset_key' WHERE email='$email';";

			
			 
			 if(mysqli_query($conn,$sql_query1))
			 {
		
				
				
					

				
				
				
			 }
            
	
}
else {

	 echo 'Error Email not Found';
} 
$conn->close();
 ?>
