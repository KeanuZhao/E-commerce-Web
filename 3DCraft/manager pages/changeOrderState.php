<?php
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	mysqli_query($DBConnection,"CALL changeOrderState('".$_GET['chosen_order_id']."','finished')");
	echo mysqli_error($DBConnection);
	mysqli_close($DBConnection);
	header("Location: management_center.php");
?>