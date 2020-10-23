<?php

$method = $_SERVER['REQUEST_METHOD'];
$project_name = 'Сайт по разработке чат-ботов';
$admin_email  = 'fvantop@gmail.com';
$form_subject = 'Заявка на чат-бота';

$name=trim($_POST["name"]);
$phone=trim($_POST["phone"]);
$email=trim($_POST["email"]);

$message = "<table style='width: 100%;'>
	<tr>
	<td style='padding: 10px; border: #e9e9e9 1px solid;background-color: #fc0;'>Имя</td>
	<td style='padding: 10px; border: #e9e9e9 1px solid;background-color: #fc0;'>Телефон</td>
	<td style='padding: 10px; border: #e9e9e9 1px solid;background-color: #fc0;'>Почта</td>
	</tr>
	<tr>
	<td style='padding: 10px; border: #e9e9e9 1px solid;'>$name</td>
	<td style='padding: 10px; border: #e9e9e9 1px solid;'>$phone</td>
	<td style='padding: 10px; border: #e9e9e9 1px solid;'>$email</td>
	</tr>
</table>";

function adopt($text) {
	return '=?UTF-8?B?'.Base64_encode($text).'?=';
}

$headers = "MIME-Version: 1.0" . PHP_EOL .
"Content-Type: text/html; charset=utf-8" . PHP_EOL .
'Отправлено с: '.adopt($project_name).' <'.$admin_email.'>' . PHP_EOL .
'Reply-To: '.$admin_email.'' . PHP_EOL;

mail($admin_email, adopt($form_subject), $message, $headers );
