<? include 'functions.php'; ?>
<?php
  header('Content-Type: text/xml');
  header('Cache-Control: no-cache');
  header('Pragma: no-cache');
      
  echo '<?xml version="1.0"?>';
  echo '<rlts>';
  
	$sql = "SELECT * FROM rlt";
	$result = mysql_query($sql) or die("Fehler bei der Abfrage: ".mysql_error());
	if(mysql_affected_rows() > 0){
		while($row = mysql_fetch_assoc($result)){
	      echo '<rlt>';
	      echo '<id>'.$row['id'].'</id>';
	      echo '<datumtext>'.$row['datumtext'].'</datumtext>';
	      echo '<turnierbez>'.$row['turnierbez'].'</turnierbez>';
	      echo '</rlt>';
		}
	}
	mysql_free_result($result);
    
  echo '</rlts>';
?>