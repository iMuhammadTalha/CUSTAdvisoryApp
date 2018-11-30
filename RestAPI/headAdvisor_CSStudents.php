<?php
 require "dbconnection.php";
 



 $sql_query = "SELECT * FROM students WHERE students.RegNo LIKE '%CS%' ORDER BY RegNo;";

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
