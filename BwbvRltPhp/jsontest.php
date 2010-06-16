<?
	header('Content-Type: text/javascript');
	header('Cache-Control: no-cache');
	header('Pragma: no-cache');

	include 'functions.php';

	echo '[';  
	$sql = "SELECT * FROM rlt";
	$result = mysql_query($sql) or die("Fehler bei der Abfrage: ".mysql_error());
	$komma = '';
	if(mysql_affected_rows() > 0){
		while($row = mysql_fetch_assoc($result)){
			echo $komma;
			echo '{ "id": '.$row['id'];
			echo ', "kat": {"id":'.$row['rltkat_id'].', "kurzbez":"kat'.$row['rltkat_id'].'"}';
			echo ', "kurzbez": "'.$row['kurzbez'].'"';
			echo ', "status": {"id":'.$row['rltstatus_id'].', "kurzbez":"status'.$row['rltstatus_id'].'"}';
			echo ', "datumtext": "'.$row['datumtext'].'"';
			echo ', "diszs": []';
			echo '}';
			$komma = ', ';
		}
	}
	echo ']';
	mysql_free_result($result);
?>
