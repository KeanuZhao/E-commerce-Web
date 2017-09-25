<?php

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	echo mysqli_error($DBConnection);

    mysqli_query($DBConnection,"USE craft;");
	echo mysqli_error($DBConnection);


    mysqli_query($DBConnection,"CALL insertUser('".$_POST['register_username']."','".$_POST['register_password']."',@success);");
	$result = mysqli_query($DBConnection,"SELECT @success");


	$row = mysqli_fetch_array($result);
	if($row[0] == TRUE)
		header("Location: login.php");//注册成功跳回登录页面
	else header("Location: register.php");//注册失败跳回注册页面

    mysqli_free_result($result);
    mysqli_close($DBConnection);

	
?>