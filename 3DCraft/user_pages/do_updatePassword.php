<?php
session_start();
if(!$_SESSION['login'])
	header("Location: login.php");

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	mysqli_query($DBConnection,"CALL updatePassword('".$_SESSION['username']."','".$_POST['old_password']."','".$_POST['new_password']."',@success);");
	$result = mysqli_query($DBConnection,"SELECT @success");
	$row = mysqli_fetch_array($result);
	
	if($row[0]){
		header("Location: do_logout.php");
	}else header("Location: updatePassword.php");
	
	mysqli_free_result($result);
	mysqli_close($DBConnection);

?>