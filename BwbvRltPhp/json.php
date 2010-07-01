<?
	include 'functions.php';

	header('Content-Type: text/javascript');
	header('Cache-Control: no-cache');
	header('Pragma: no-cache');

    $query = $_GET["q"];
	if ($query == "getrlts") {
		echo getJsonFromDB("select rlt.id, rlt.kurzbez, rlt.turnierbez, rlt.datumtext, 
				rltkat_id, rltkat.kat, rltkat.katbez,  
				rltstatus_id, rltstatus.status, rltstatus.statusbez 
				from rlt 
				inner join rltkat on rlt.rltkat_id = rltkat.id
				inner join rltstatus on rlt.rltstatus_id = rltstatus.id
				order by rlt.rltkat_id, rlt.datum");
	} else 
	if ($query == "getrlt") {
		$id = $_GET["id"];
		echo getJsonFromDB("select * from rlt where id=$id");
	} else 
		echo "invalid request: $query";
?>
