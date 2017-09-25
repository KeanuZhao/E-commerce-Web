<?php
	session_start();
	if(!$_SESSION['manager_login'])
		header("Location: manager_login.php");
	
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	
	//执行查询订单
	if($_REQUEST['search_choice'] == "order"){
		//echo $_REQUEST['search_choice'];
		$result_allOrders = mysqli_query($DBConnection,"CALL searchOrderOfManager('".$_GET['keywords']."')");
		//echo mysql_error($DBConnection);
		while($row = mysqli_fetch_assoc($result_allOrders)){
			echo "----------------------------------------------------------<br/>";
			echo $row['order_id']."<br/>";
			echo $row['customization_product_id']."<br/>";
			echo $row['user_username']."<br/>";
			echo $row['process']."<br/>";
			echo $row['name']."<br/>";
			echo $row['telephone']."<br/>";
			echo $row['address']."<br/>";
			echo $row['code']."<br/>";
			echo $row['total_price']."<br/>";
			echo $row['quantity']."<br/>";
			if($row['process'] != "finished"){//未完成的可以修改状态
				$chosen_order_id = $row['order_id'];
				echo "<form action='changeOrderState.php' method='GET'>
				<input type='hidden' name='chosen_order_id' value='$chosen_order_id'/>
				<input type='submit' name='submit' value='Finished'/>
				</form>";
			}
				
			echo "----------------------------------------------------------";
			echo "<br/><br/>";
		}
		echo "<a href='management_center.php'>Back</a>";
		mysqli_free_result($result_allOrders);
		mysqli_close($DBConnection);
	}
		
	//执行查询产品
	if($_REQUEST['search_choice'] == "product"){
		$result_products = mysqli_query($DBConnection,"CALL searchProducts('".$_GET['keywords']."')");
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
		echo "<a href='management_center.php'>Back</a>";
		mysqli_close($DBConnection);
	}
?>