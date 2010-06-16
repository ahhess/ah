<?
function connect()
{
    $con= mysql_connect("localhost","root","") or die(mysql_error());
    mysql_select_db("bwbvrltonline",$con) or die(mysql_error());
}

function check_user($benutzer, $pass)
{
    $sql="SELECT id FROM rltbenutzer WHERE benutzer='".$benutzer."' AND pwd='".$pass."' LIMIT 1";
    $result= mysql_query($sql) or die(mysql_error());
    if ( mysql_num_rows($result)==1)
    {
        $user=mysql_fetch_assoc($result);
        return $user['id'];
    }
    else
        return -1;
}

function login($benutzer)
{
    $sql="UPDATE rltbenutzer SET UserSession='".session_id()."' WHERE benutzer='".$benutzer."'";
     mysql_query($sql);
}

function logged_in()
{
    $sql="SELECT id FROM rltbenutzer WHERE UserSession='".session_id()."' LIMIT 1";
    $result= mysql_query($sql);
    return ( mysql_num_rows($result)==1);
}

function get_benutzer()
{
    $sql="SELECT benutzer FROM rltbenutzer WHERE UserSession='".session_id()."' LIMIT 1";
    $result= mysql_query($sql) or die(mysql_error());
    if ( mysql_num_rows($result)==1)
    {
        $user=mysql_fetch_assoc($result);
        return $user['benutzer'];
    }
    else
        return -1;
}

function logout()
{
    $sql="UPDATE rltbenutzer SET UserSession=NULL WHERE UserSession='".session_id()."'";
	mysql_query($sql);
}

function getJsonFromDB($query) {
	//echo "getJsonFromDB($query)\n";
	$res = mysql_query($query) or die("mysql_error from: $query");
	while ($row = mysql_fetch_assoc($res)) {
		for ($i=0; $i < mysql_num_fields($res); $i++) {
			$info = mysql_fetch_field($res, $i);
			$type = $info->type;
			// cast for real
			if ($type == 'real')
				$row[$info->name] = doubleval($row[$info->name]);
			// cast for int
			if ($type == 'int')
				$row[$info->name] = intval($row[$info->name]);
		}
		$rows[] = $row;
	}
	// JSON-ify all rows together as one big array
	$ret = json_encode($rows);	   
	mysql_free_result($res);
	return $ret;
}

connect();
?>