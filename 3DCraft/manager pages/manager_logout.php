<?php
	session_start();
	$_SESSION['manager_login'] = FALSE;
	$_SESSION['manager_id'] = NULL;
	header("Location: manager_login.php");
?>