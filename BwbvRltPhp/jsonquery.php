<?
	header('Content-Type: text/javascript');
	header('Cache-Control: no-cache');
	header('Pragma: no-cache');

	include 'functions.php';

    //$query = 'select * from rlt';
    $query = $_GET["q"];
    $res = mysql_query($query);

    // iterate over every row
    while ($row = mysql_fetch_assoc($res)) {
        // for every field in the result..
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
    echo json_encode($rows);
   
	mysql_free_result($res);
?>
