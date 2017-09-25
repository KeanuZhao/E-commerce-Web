<?php
	session_start();
	if(!$_SESSION['login'])
		header("Location: login.php");
	$product_id = $_GET['chosen_product_id'];
?>
<form action="do_editProductInfo.php" method="post"  enctype="multipart/form-data">
	
	image:<input type="file" name="product_image" id="file"/>
	<br>product name: <input type="text" name="product_name" value=""/>
	<br>description:<input type="text" name="description" value=""/>
	<br><input type="hidden" name="product_id" value="<?php echo $product_id;?>"/>
	
	<br><input type="submit" name="submit" value="submit"/>
	
</form>