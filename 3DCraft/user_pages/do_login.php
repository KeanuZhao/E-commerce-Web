<?php 
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	$success = mysqli_query($DBConnection,"USE craft;");
	echo mysqli_error($DBConnection);
	$query = "CALL userLogin('".$_POST['username']."','".$_POST['password']."',@success);";
	
	mysqli_query($DBConnection,$query);
	echo mysqli_error($DBConnection);
	$result = mysqli_query($DBConnection,"SELECT @success;");
	
	$row = mysqli_fetch_array($result);
		
	session_start();
	if($row[0]){
		$_SESSION['login'] = TRUE;
		$_SESSION['username'] = $_POST['username'];
		echo "Login success!";
		echo "Welcome ".$_SESSION['username'];
		header("Location: homepage.php");//��½�ɹ�������ҳ
	}
	else {
		$_SESSION['login'] = FALSE;
		header("Location: login.php");//��¼ʧ�����ص�¼ҳ��
	}
	
	mysqli_free_result($result);
	mysqli_close($DBConnection);
?>