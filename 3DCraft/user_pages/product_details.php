<?php
	if(!isset($_GET['chosen_product_id']))
		header("Location: homepage.php");

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	
	$result = mysqli_query($DBConnection,"SELECT username, size, material, color,price, description, product_name, product_id,image_path 
			FROM vwproduct_customization WHERE product_id='".$_REQUEST['chosen_product_id']."'");
	echo mysqli_error($DBConnection);
	
	while($row = mysqli_fetch_assoc($result)){
		echo "product_name: ".$row['product_name']." <br/>";
		echo "product_id: ".$row['product_id']." <br/>";
		echo "description: ".$row['description']." <br/>";
		echo "price: ".$row['price']." <br/>";
		echo "color: ".$row['color']." <br/>";
		echo "Customizer: ".$row['username']."<br/>";
	}
	
	mysqli_free_result($result);
	mysqli_close($DBConnection);
?>

<br/><a href="homepage.php">Back to homepage.</a>