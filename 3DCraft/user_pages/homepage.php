<html>
<head>
	<title>homepage</title>
</head>
<body>
<p>This is the homepage.</p><br/>

<?php 
	//����session��ʼ״̬����¼session�����ڳ�ʼ����Ϊfalse
	session_start();
	if(!isset($_SESSION['login']))
		$_SESSION['login'] = FALSE;
	
	if(!isset($_SESSION['username']))
		$_SESSION['username'] = NULL;
	
	if(!$_SESSION['login'])
		echo "<a href='login.php'>login</a>";
	else{
		echo "Welcome ".$_SESSION['username']."   ";	
		echo "<a href = 'user_center.php'>user center</a><br/>";
		echo "<a href = 'do_logout.php'>logout</a>";
	}
		
?>

<br/><a href = "customization.php">customization</a><br/><br/>

<!-- ������Ʒ-->
<form action="search_result.php" method="get">
	<input type="text" name="keywords" value=""/>
	<input type="submit" name="submit" value="Search"/><br/>
</form>

<?php 
	//��Ʒ�б�
	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	$result = mysqli_query($DBConnection,"CALL getAllProducts()");
	
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
	mysqli_free_result($result);
	mysqli_close($DBConnection);

?>
</body>
</html>