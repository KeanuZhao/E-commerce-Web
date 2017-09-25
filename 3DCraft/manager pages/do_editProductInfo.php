<?php
	session_start();
	//²ÎÊý¼ì²â
	if(!validateRequestParameter())
		header("Location: editProductInfo.php");

	$filename = $_FILES['product_image']['name'];
	$upload_path = "../product images/";
	echo $_FILES['product_image']['name'];
	if(move_uploaded_file($_FILES['product_image']['tmp_name'],$upload_path.$filename)){
		echo "Upload succeed!    <br>";
		rename($upload_path.$filename,$upload_path.$_REQUEST['product_id'].".jpg");
	}

	$file_path = $upload_path.$_REQUEST['product_id'].".jpg";
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	echo mysqli_error($DBConnection);
	mysqli_query($DBConnection,"USE craft;");
	echo mysqli_error($DBConnection);
	
	mysqli_query($DBConnection,"CALL editProductInfo('".$file_path."','".$_REQUEST['description']."','".$_REQUEST['product_id']."','".$_REQUEST['product_name']."');");
	echo mysqli_error($DBConnection);
	
	mysqli_close($DBConnection);
	
	header("Location: management_center.php");
	?>

<?php 
	function validateRequestParameter(){
		return TRUE;
	}
?>