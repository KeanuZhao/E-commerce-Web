<?php
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	$success = mysqli_query($DBConnection,"USE craft;");
	$result = mysqli_query($DBConnection,"CALL searchProducts('".$_GET['keywords']."')");
?>

<!-- ËÑË÷²úÆ· -->
<form action="search_result.php" method="get">
	<input type="text" name="keywords" value=""/>
	<input type="submit" name="submit" value="Search"/><br/>
</form>

<?php	
	while($row = mysqli_fetch_assoc($result)){
		echo "product_name: ".$row['product_name']." ";
		echo "product_id: ".$row['product_id']." ";
		echo "description: ".$row['description']." ";
		$chosen_product_id = $row['product_id'];
		echo "<form action='product_details.php' method='GET'>
		<input type='hidden' name='chosen_product_id' value='$chosen_product_id'/>
		<input type='submit' name='submit' value='See Details'/>
		</form>";
		echo "<form action='customize_existing_products.php' method='GET'>
		<input type='hidden' name='chosen_product_id' value='$chosen_product_id'/>
		<input type='submit' name='submit' value='I want it!'/>
		</form>";
		echo "<br>";
	}
	mysqli_close($DBConnection);
?>

<a href="homepage.php">Back to home page</a>