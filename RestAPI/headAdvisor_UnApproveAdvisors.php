<?php
 require "dbconnection.php";
 
  $sql_query = "SELECT * FROM advisors WHERE isApprove='No' ;";

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
