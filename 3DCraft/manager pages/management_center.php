<?php
	session_start();
	if(!$_SESSION['manager_login'])
		header("Location: manager_login.php");
?>

<h2>Welcome manager <?php echo $_SESSION['manager_id']?>!</h2><br/>
<a href="manager_logout.php">Logout</a>

<!-- 搜索 -->
<form action="manager_search_result.php" method="get">
	<input type="text" name="keywords" value=""/>
	<select name="search_choice">
		<option value="order">Order</option>
		<option value="product">Product</option>
	</select>
	<input type="submit" name="submit" value="Search"/><br/>
</form>

<?php 
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	//显示未完成订单
	Echo "<h3>Unfinished Order: </h3><br/>";
	$result_unfinishedOrder = mysqli_query($DBConnection,"CALL showUnfinishedOrder()");
	while($row = mysqli_fetch_assoc($result_unfinishedOrder)){
		echo "order id: ".$row['order_id']." <br/>";
		echo "product id: ".$row['customization_product_id']." <br/>";
		echo "process: ".$row['process']." <br/>";
		echo "name: ".$row['name']." <br/>";
		echo "telephone: ".$row['telephone']." <br/>";
		echo "address: ".$row['address']." <br/>";
		echo "postcode: ".$row['code']." <br/>";
		echo "total price: ".$row['total_price']." <br/>";
		echo "quantity: ".$row['quantity']." ";
		echo "username: ".$row['user_username']." <br/>";
		
		$chosen_order_id = $row['order_id'];
		echo "<form action='changeOrderState.php' method='GET'>
		<input type='hidden' name='chosen_order_id' value='$chosen_order_id'/>
		<input type='submit' name='submit' value='Finished'/>
		</form>";
		echo "<br><br>";
	}
	mysqli_free_result($result_unfinishedOrder);
	mysqli_close($DBConnection);
	echo "-----------------------------------------------------";
	
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	//显示已完成订单
	echo "<h3>Finished Order: </h3><br/>";
	$result_finishedOrder = mysqli_query($DBConnection,"CALL showFinishedOrder()");
	echo mysqli_error($DBConnection);
	while($row = mysqli_fetch_assoc($result_finishedOrder)){
		echo "order id: ".$row['order_id']." <br/>";
		echo "product id: ".$row['customization_product_id']." <br/>";
		echo "process: ".$row['process']." <br/>";
		echo "name: ".$row['name']." <br/>";
		echo "telephone: ".$row['telephone']." <br/>";
		echo "address: ".$row['address']." <br/>";
		echo "postcode: ".$row['code']." <br/>";
		echo "total price: ".$row['total_price']." <br/>";
		echo "quantity: ".$row['quantity']." ";
		echo "username: ".$row['user_username']." <br/>";
		echo "<br><br>";
	}
	mysqli_free_result($result_finishedOrder);
	mysqli_close($DBConnection);
	echo "-----------------------------------------------------";

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	//显示产品
	echo "<h3>Products: </h3><br/>";
	$result_products = mysqli_query($DBConnection,"CALL getAllProducts()");
	echo mysqli_error($DBConnection);
	while($row = mysqli_fetch_assoc($result_products)){
		echo "image_path: ".$row['image_path']." <br/>";
		echo "product id: ".$row['product_id']." <br/>";
		echo "product name: ".$row['product_name']." <br/>";
		echo "description: ".$row['description']." <br/>";
		
		$chosen_product_id = $row['product_id'];
		echo "<form action='editProductInfo.php' method='GET'>
		<input type='hidden' name='chosen_product_id' value='$chosen_product_id'/>
		<input type='submit' name='submit' value='Edit info'/>
		</form>";
		echo "<br><br>";
	}
	mysqli_free_result($result_products);
	mysqli_close($DBConnection);
	
?>