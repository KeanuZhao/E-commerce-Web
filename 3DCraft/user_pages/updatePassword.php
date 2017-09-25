<?php
	session_start();
	if(!$_SESSION['login'])
		header("Location: login.php");
?>

<!-- ÐÞ¸ÄÃÜÂë -->
<form action="do_updatePassword.php" method="post">
	Old password: <input type="password" name="old_password"/><br/>
	New password: <input type="password" name="new_password"/><br/>
	<input type="submit" name="submit" value="submit"/>
</form>