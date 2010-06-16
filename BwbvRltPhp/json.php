<?
	include 'functions.php';

	header('Content-Type: text/javascript');
	header('Cache-Control: no-cache');
	header('Pragma: no-cache');

    $query = $_GET["q"];
	if ($query == "getrlts") {
		echo getJsonFromDB("select * from rlt order by rltkat_id, datum");
	} else 
	if ($query == "getrlt") {
		$id = $_GET["id"];
		echo getJsonFromDB("select * from rlt where id=$id");
	} else 
		echo "invalid request: $query";
?>
