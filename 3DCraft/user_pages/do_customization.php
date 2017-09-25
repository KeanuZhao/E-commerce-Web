<?php
	session_start();
	//²ÎÊý¼ì²â
	if(!validateRequestParameter())
		header("Location: customization.php");
		
	$filename = $_FILES['draft']['name'];
	$upload_path = "../drafts/";
	echo $_FILES['draft']['name'];
	if(move_uploaded_file($_FILES['draft']['tmp_name'],$upload_path.$filename)){
		echo "Upload succeed! <br>";
		rename($upload_path.$filename,$upload_path.$_REQUEST['product_id'].".cad");
	}
	
	
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	echo mysqli_error($DBConnection);
	mysqli_query($DBConnection,"USE craft;");
	echo mysqli_error($DBConnection);
	
	$new_filename = $upload_path.$_REQUEST['product_id'].".cad";
	$price = calculatePrice();
	$total_price = (integer)$_POST['quantity']*$price;
	$query_insertCustomization = "CALL insertCustomization
								('".$_POST['product_id']."',
								'".$_SESSION['username']."',
								'".$new_filename."',
								'".$_POST['size']."',
								'".$_POST['material']."',
								'".$_POST['color']."',
								'".$price."');";
	//echo $query_insertCustomization."<br>";
	mysqli_query($DBConnection,$query_insertCustomization);
	echo mysqli_error($DBConnection);
	
	mysqli_query($DBConnection,"CALL insertOrder(
								'".$_POST['order_id']."',
								'".$_POST['name']."',
								'".$_POST['telephone']."',
								'".$_POST['address']."',
								'".$_POST['code']."',
								'".$total_price."',
								'".(integer)$_POST['quantity']."',
								'unfinished',
								'".$_POST['product_id']."',
								'".$_SESSION['username']."');");
	echo mysqli_error($DBConnection);
	mysqli_close($DBConnection);
	
	echo "product_id: ".$_REQUEST['product_id']."<br>";
	echo "order_id: ". $_REQUEST['order_id']."<br>";
	echo "username: ". $_REQUEST['username']."<br>";
	echo "draft path: ".$new_filename."<br>";
	echo "size: ". $_POST['size']."<br>";
	echo "material: ".$_POST['material']."<br>";
	echo "color:" .$_POST['color']."<br>";
	echo "name: ".$_POST['name']."<br>";
	echo "telephone:".$_POST['telephone']."<br>";
	echo "address:".$_POST['address']."<br>";
	echo "postcode: ".$_POST['code']."<br>";
	echo "price:" .$price."<br>";
	echo "quantity".$_POST['quantity']."<br>";
	echo "total price: ".$total_price."<br>";
	
	function calculatePrice(){
		$price = 100;
		return $price;
	}

?>

<?php 
	function validateRequestParameter(){
		return TRUE;
	}
?>

<p>Order success! Click <a href="homepage.php" >Back to homepage</a></p>

