<?
	include 'functions.php';

	header('Content-Type: text/javascript');
	header('Cache-Control: no-cache');
	header('Pragma: no-cache');

    $query = $_GET["q"];
	if ($query == "getrlts") {
		echo getJsonFromDB("select rlt.id, rlt.kurzbez, rlt.turnierbez, rlt.datumtext, 
				rlt.ort, rlt.halle, rlt.adresse, rlt.meldeschluss,
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
	if ($query == "getusers") {
		echo getJsonFromDB("SELECT id,benutzer,pwd FROM rltbenutzer");
	} else 
	if ($query == "login") {
		$usr = $_GET["u"];
		$pwd = $_GET["p"];
		$uid = check_user($usr, $pwd);
		if ($uid != -1) {
			login($usr);
		}
		echo json_encode($uid);
	} else 
		echo "invalid request: $query";
?>
