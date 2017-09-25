<?php 
	//session_start();
	//if($_SESSION['manager_login'])
		//header("Location: management_center.php");
?>
<form action="do_managerLogin.php" method="post">
	Manager ID: <input type="text" name="manager_id"/><br/>
	password: <input type="password" name="manager_password"/><br/>
	<input type="submit" name="submit" value ="submit"/>
</form>