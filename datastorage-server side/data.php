<?php
$file = 'data.txt';
if(isset($_REQUEST['data'])){
	$current ="";
	if(file_exists($file))
	$current = file_get_contents($file);
	
	$current .= $_REQUEST['data'];
	
	file_put_contents($file, $current);
}

if(isset($_REQUEST['exc']) and $_REQUEST['exc']=="del"){
	 
	 unlink($file);
}
if(isset($_REQUEST['exc']) and $_REQUEST['exc']=="view"){
	 
	if(file_exists($file))
	echo  file_get_contents($file);
	else echo '';
}


?>