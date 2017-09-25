<?php
	session_start();
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	$success = mysqli_query($DBConnection,"USE craft;");
	echo "11111";
	echo mysqli_error($DBConnection);
	mysqli_query($DBConnection,"CALL managerLogin('".$_POST['manager_id']."','".$_POST['manager_password']."',@success)");
	
	$result = mysqli_query($DBConnection,"SELECT @success");
	echo mysqli_error($DBConnection);
	
	$row = mysqli_fetch_array($result);
	if($row[0]){
		header("Location: management_center.php");
		$_SESSION['manager_login'] = TRUE;
		$_SESSION['manager_id'] = $_POST['manager_id'];
		mysqli_free_result($result);
		mysqli_close($DBConnection);
	}
	else header("Location: manager_login.php");
	
?>