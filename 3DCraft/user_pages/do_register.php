<?php

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	echo mysqli_error($DBConnection);

    mysqli_query($DBConnection,"USE craft;");
	echo mysqli_error($DBConnection);


    mysqli_query($DBConnection,"CALL insertUser('".$_POST['register_username']."','".$_POST['register_password']."',@success);");
	$result = mysqli_query($DBConnection,"SELECT @success");


	$row = mysqli_fetch_array($result);
	if($row[0] == TRUE)
		header("Location: login.php");//ע��ɹ����ص�¼ҳ��
	else header("Location: register.php");//ע��ʧ������ע��ҳ��

    mysqli_free_result($result);
    mysqli_close($DBConnection);

	
?>