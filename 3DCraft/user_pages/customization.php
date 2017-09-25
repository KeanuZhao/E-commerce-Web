<?php
session_start();
if(!$_SESSION['login'])
	header("Location: login.php");
?>

<form action="do_customization.php" method="post"  enctype="multipart/form-data">
	
	<input type="hidden" name="product_id" value="<?php echo generateId();?>"/>
	<input type="hidden" name="username" value="<?php echo $_SESSION['username'];?>"/>
	draft:<input type="file" name="draft" id="file"/>
	<br>size<input type="text" name="size" value="Large"/>
	<br>material:<input type="text" name="material" value="Plastic"/>
	<br>color:<input type="text" name="color" value="Red"/>
	
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