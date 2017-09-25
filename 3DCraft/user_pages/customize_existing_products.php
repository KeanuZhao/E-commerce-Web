<?php
	session_start();
	if(!$_SESSION['login'])
		header("Location: login.php");

	$DBConnection = mysqli_connect("localhost", "root", "000000");
	mysqli_query($DBConnection,"USE craft");
	$result = mysqli_query($DBConnection,"CALL queryCustomization('".$_GET['chosen_product_id']."')");
	
	$row = mysqli_fetch_assoc($result);
?>
	<form action="do_existing_customization.php" method="post"  enctype="multipart/form-data">
	
	<input type="hidden" name="draft_path" value="<?php echo $row['draft_path'];?>"/>
	<input type="hidden" name="product_id" value="<?php echo generateId();?>"/>
	<input type="hidden" name="username" value="<?php echo $_SESSION['username'];?>"/>
	<br>size: <input type="text" name="size" value="<?php echo $row['size'];?>"/>
	<br>material:<input type="text" name="material" value="<?php echo $row['material'];?>"/>
	<br>color:<input type="text" name="color" value="<?php echo $row['color'];?>"/>
	
	<input type="hidden" name="order_id" value="<?php echo generateId();?>"/>
	<br>name: <input type="text" name="name" value="Jingwen Hou"/>
	<br>telephone:<input type="text" name="telephone" value="13266543456"/>
	<br>address:<input type="text" name="address" value="Beijing"/>
	<br>postcode:<input type="text" name="code" value="102209"/>
	<br>quantity:<input type="text" name="quantity" value="3"/>
	
	<br><input type="submit" name="submit" value="submit"/>
	
	</form>
<?php
	function generateId(){
		$str1 = 10000000000 * microtime() / rand(23,97);
		$str1 = (string)round($str1);
		$str2 = 20000000000 * microtime() / rand(33,57);
		$str2 = (string)round($str2);
		$id = $str1."".$str2;
		return $id;
	}
?>