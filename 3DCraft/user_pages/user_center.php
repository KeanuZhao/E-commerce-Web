<?php
	session_start();
	if(!$_SESSION['login'])
		header("Location: login.php");
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	
?>
<a href="updatePassword.php">Change password</a><br/>


<form action="user_center.php" method="get">
	<input type="text" name="query_order_keywords" value=""/>
	<input type="submit" name="submit" value="Search"/><br/>
</form>

<?php 
	//��ʾ��ѯ�Ķ���
	if(isset($_GET['query_order_keywords'])){
		$result_searchById = mysqli_query($DBConnection,"CALL searchOrderOfUser('".$_GET['query_order_keywords']."','".$_SESSION['username']."')");
		echo "<p>Here are your searching results</p><br/>";
		while($row = mysqli_fetch_assoc($result_searchById)){
			echo "----------------------------------------------------------<br/>";
			echo "order id".$row['order_id']."<br/>";
			echo $row['customization_product_id']."<br/>";
			echo $row['process']."<br/>";
			echo $row['name']."<br/>";
			echo $row['telephone']."<br/>";
			echo $row['address']."<br/>";
			echo $row['code']."<br/>";
			echo $row['total_price']."<br/>";
			echo $row['quantity']."<br/>";
			echo "----------------------------------------------------------";
			echo "<br/><br/>";
		}
		mysqli_free_result($result_searchById);
	}

	
	//��ʾ���ж���
	if(!isset($_GET['query_order_keywords'])){
		$result_allOrders = mysqli_query($DBConnection,"CALL queryOrdersByUsername('".$_SESSION['username']."')");
		//echo mysql_error($DBConnection);
		while($row = mysqli_fetch_assoc($result_allOrders)){
			echo "----------------------------------------------------------<br/>";
			echo $row['order_id']."<br/>";
			echo $row['customization_product_id']."<br/>";
			echo $row['process']."<br/>";
			echo $row['name']."<br/>";
			echo $row['telephone']."<br/>";
			echo $row['address']."<br/>";
			echo $row['code']."<br/>";
			echo $row['total_price']."<br/>";
			echo $row['quantity']."<br/>";
			echo "----------------------------------------------------------";
			echo "<br/><br/>";
		}
		mysqli_free_result($result_allOrders);
	}
	
	mysqli_close($DBConnection);
?>