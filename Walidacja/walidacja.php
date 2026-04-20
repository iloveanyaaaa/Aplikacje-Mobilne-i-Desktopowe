<head>
<link rel="stylesheet" href="style.css">
<title>formularz</title>
</head>
<?php
session_start();
$db=mysqli_connect('localhost','root','','zadania');
$imie=$_POST['imie'];
$nazwisko=$_POST['nazwisko'];
$ulica=$_POST['ulica'];
$nr=$_POST['nr'];
$miasto=$_POST['miasto'];
$kod=$_POST['kod'];
$tel=$_POST['tel'];
$r1='/^[0-9]{2}-[0-9]{3}$/';
$r2='/^\+[0-9]{2} [0-9]{3} [0-9]{3} [0-9]{3}$/';

if(preg_match($r1,$kod)){
if(preg_match($r2,$tel)){
if($nr==NULL){
$q="INSERT INTO formularz(imie,nazwisko,ulica,miasto,kod_pocztowy,telefon) VALUES('$imie','$nazwisko','$ulica','$miasto','$kod','$tel')";
mysqli_query($db,$q);
echo "<h2>ok</h2>";
}else{
$q="INSERT INTO formularz(imie,nazwisko,ulica,nr_mieszkania,miasto,kod_pocztowy,telefon) VALUES('$imie','$nazwisko','$ulica','$nr','$miasto','$kod','$tel')";
mysqli_query($db,$q);
echo "<h2>ok</h2>";
}

}else{
echo "<h2>zly telefon</h2>";
}
}else{
echo "<h2>zly kod</h2>";
}
?>