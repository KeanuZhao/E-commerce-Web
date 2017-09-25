<?php
session_start();
$_SESSION['login'] = FALSE;
$_SESSION['username'] = NULL;
header("Location: homepage.php");
?>