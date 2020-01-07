<?php
 

if (isset($_POST['register'])) {
 
    $username = $_POST['username'];
    
    $password = $_POST['password'];
   
    if ($username == 'vaaibhav' && $password == 'newpass') {
        echo 'Success';
    }
    else {
            echo 'Failed';
        }
    }

    // echo 'Working'; 
?>

