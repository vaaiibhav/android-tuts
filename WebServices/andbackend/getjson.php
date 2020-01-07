<?php
error_reporting(E_ERROR | E_PARSE);


$studentdetails -> name = "Vaibhav";
$studentdetails -> age = 29;
$studentdetails -> class = "Android";


$echodata = json_encode($studentdetails);
echo($echodata);

?>