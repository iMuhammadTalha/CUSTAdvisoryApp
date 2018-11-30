<?php
 require "dbconnection.php";
 
 $Advisor = $_POST["advisor_name"];
 $FirstStd = $_POST["first"]; 
 $LastStd = $_POST["last"];

 
 $sql_query = "INSERT INTO `assigned_students`(`Advisor_ID`, `No_of_students`, `First_student`, `Last_student`) VALUES ((SELECT advisors.ID FROM advisors WHERE advisors.Name='$Advisor'),(SELECT COUNT(RegNo) FROM students WHERE students.RegNo BETWEEN '$FirstStd' AND '$LastStd'),'$FirstStd','$LastStd');";

 $sql_query2 = "UPDATE `advisors` SET `isApprove`='Yes' WHERE `Name`='$Advisor';";
 
 $result = mysqli_query($conn,$sql_query);
 
 

if($result>0)
{
	 mysqli_query($conn,$sql_query2);

		echo 'Added';
 

}
else
{
	echo 'Not';
}




$conn->close();
 ?>
